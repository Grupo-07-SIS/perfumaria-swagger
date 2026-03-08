package com.example.perfumaria_swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetoindividual.Entitie.Decant;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/decantes")
public class DecanteController {

    private final JdbcTemplate jdbcTemplate;

    public DecanteController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping
    public ResponseEntity<Decant> cadastrar(@RequestBody Decant decant) {
        if (decant.getIdFragrancia() == null || decant.getCapacidadeMl() == null || decant.getPreco() == null) {
            return ResponseEntity.badRequest().build();
        }

        List<Decant> decantesExistentes = jdbcTemplate.query("select * from decant where id_fragrancia = ? and capacidade_ml = ?",
                new BeanPropertyRowMapper<>(Decant.class), decant.getIdFragrancia(), decant.getCapacidadeMl());

        if (!decantesExistentes.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        jdbcTemplate.update("insert into decant (id_fragrancia, capacidade_ml, preco) values (?, ?, ?)",
                decant.getIdFragrancia(), decant.getCapacidadeMl(), decant.getPreco());
        return ResponseEntity.status(HttpStatus.CREATED).body(decant);
    }
}
