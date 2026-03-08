package com.example.perfumaria_swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetoindividual.Entitie.Marca;

import java.sql.Statement;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final JdbcTemplate jdbcTemplate;

    public MarcaController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Marca>> buscarMarcas() {
        List<Marca> marcas = jdbcTemplate.query("select * from marca", new BeanPropertyRowMapper<>(Marca.class));
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarMarcaPorId(@PathVariable Integer id) {
        List<Marca> marcas = jdbcTemplate.query("select * from marca where id = ?", new BeanPropertyRowMapper<>(Marca.class), id);

        if (marcas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(marcas.get(0));
    }

    @PostMapping
    public ResponseEntity<Marca> cadastrarMarca(@RequestBody Marca marca) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        List<Marca> marcasExistentes = jdbcTemplate.query("select * from marca where nome = ?",
                new BeanPropertyRowMapper<>(Marca.class), marca.getNome());

        if (!marcasExistentes.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement("insert into marca (nome, slug) values (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, marca.getNome());
            ps.setString(2, marca.getNome().toLowerCase().replaceAll("\\s+", "-"));
            return ps;
        }, keyHolder);

        Long id = keyHolder.getKey().longValue();

        Marca marcaCadastrada = jdbcTemplate.queryForObject("select * from marca where id = ?",
                new BeanPropertyRowMapper<>(Marca.class), id);

        return ResponseEntity.ok(marcaCadastrada);
    }
}
