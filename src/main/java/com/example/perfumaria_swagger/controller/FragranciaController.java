package com.example.perfumaria_swagger.controller;

import java.sql.Statement;
import java.util.List;

import com.example.perfumaria_swagger.model.Fragrancia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/fragrancias")
public class FragranciaController {

    private final JdbcTemplate jdbcTemplate;

    public FragranciaController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Fragrancia>> listarFragrancias() {

        List<Fragrancia> fragrancias = jdbcTemplate.query("select * from fragrancia",
                new BeanPropertyRowMapper<>(Fragrancia.class));

        return ResponseEntity.ok(fragrancias);
    }

    @PostMapping
    public ResponseEntity<Fragrancia> cadastrarFragrancia(@RequestBody Fragrancia fragrancia) {

       if(fragrancia.getNome() == null || fragrancia.getNome().trim().isEmpty() ||
          fragrancia.getIdMarca() == null ||
          fragrancia.getConcentracao() == null ||
          fragrancia.getDataAquisicao() == null) {
            return ResponseEntity.badRequest().build();
        }

        List<Fragrancia> fragranciasExistentes = jdbcTemplate.query("select * from fragrancia where nome = ?",
                new BeanPropertyRowMapper<>(Fragrancia.class), fragrancia.getNome());

        if (!fragranciasExistentes.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(
                    "insert into fragrancia (nome, id_marca, concentracao, data_aquisicao) values (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, fragrancia.getNome());
            ps.setInt(2, fragrancia.getIdMarca());
            ps.setString(3, fragrancia.getConcentracao().name());
            ps.setDate(4, java.sql.Date.valueOf(fragrancia.getDataAquisicao()));
            return ps;
        }, keyHolder);

        Long id = keyHolder.getKey().longValue();

        Fragrancia fragranciaCadastrada = jdbcTemplate.queryForObject("select * from fragrancia where id = ?",
                new BeanPropertyRowMapper<>(Fragrancia.class), id);

        return ResponseEntity.status(HttpStatus.CREATED).body(fragranciaCadastrada);

    }

}
