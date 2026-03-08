package com.example.perfumaria_swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.perfumaria_swagger.model.Marca;

@RestController
@RequestMapping("/marcas")
@Tag(name = "Marcas", description = "Gerenciamento de marcas de perfumes")
public class MarcaController {

    // ========== GET ==========
    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna uma lista de todas as marcas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Marca.class))),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(501).build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna uma marca específica pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Marca encontrada",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Marca.class))),
        @ApiResponse(responseCode = "404", description = "Marca não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }

    // ========== POST ==========
    @PostMapping
    @Operation(summary = "Criar novo", description = "Cria uma nova marca")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Marca criada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Marca.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> save(@RequestBody Marca marca) {
        return ResponseEntity.status(501).build();
    }

    // ========== PUT ==========
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza uma marca existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Marca atualizada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Marca.class))),
        @ApiResponse(responseCode = "404", description = "Marca não encontrada"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Marca marca) {
        return ResponseEntity.status(501).build();
    }

    // ========== DELETE ==========
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar", description = "Remove uma marca pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Marca deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Marca não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }
}
