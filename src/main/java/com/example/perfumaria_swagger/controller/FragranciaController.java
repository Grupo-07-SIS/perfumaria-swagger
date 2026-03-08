package com.example.perfumaria_swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.perfumaria_swagger.model.Fragrancia;

@RestController
@RequestMapping("/fragrancias")
@Tag(name = "Fragrâncias", description = "Gerenciamento de fragrâncias do catálogo")
public class FragranciaController {

    // ========== GET ==========
    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna uma lista de todas as fragrâncias")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Fragrancia.class))),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(501).build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna uma fragrância específica pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fragrância encontrada",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Fragrancia.class))),
        @ApiResponse(responseCode = "404", description = "Fragrância não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }

    // ========== POST ==========
    @PostMapping
    @Operation(summary = "Criar novo", description = "Cria uma nova fragrância")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Fragrância criada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Fragrancia.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> save(@RequestBody Fragrancia fragrancia) {
        return ResponseEntity.status(501).build();
    }

    // ========== PUT ==========
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza uma fragrância existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fragrância atualizada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Fragrancia.class))),
        @ApiResponse(responseCode = "404", description = "Fragrância não encontrada"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Fragrancia fragrancia) {
        return ResponseEntity.status(501).build();
    }

    // ========== DELETE ==========
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar", description = "Remove uma fragrância pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Fragrância deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Fragrância não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }
}
