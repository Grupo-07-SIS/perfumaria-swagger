package com.example.perfumaria_swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetoindividual.Entitie.FragranciaNota;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/fragrancias-notas")
public class FragranciaNotasController {

    public final JdbcTemplate jdbcTemplate;

    public FragranciaNotasController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping
    public ResponseEntity<FragranciaNota> vincularFragranciaAsNotas(@RequestBody FragranciaNota fragranciaNota){
        if(fragranciaNota.getIdFragrancia() == null || fragranciaNota.getIdNota() == null){
            return ResponseEntity.badRequest().build();
        }

        List<FragranciaNota> fragranciaNotas = jdbcTemplate.query("select * from fragrancia_nota where id_fragrancia = ? and id_nota = ?", new BeanPropertyRowMapper<>(FragranciaNota.class), fragranciaNota.getIdFragrancia(), fragranciaNota.getIdNota());

        if(!fragranciaNotas.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        jdbcTemplate.update("insert into fragrancia_nota (id_fragrancia, id_nota) values (?, ?)", fragranciaNota.getIdFragrancia(), fragranciaNota.getIdNota());
        return ResponseEntity.status(HttpStatus.CREATED).body(fragranciaNota);
    }
}
