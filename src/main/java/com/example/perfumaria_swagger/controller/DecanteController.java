package com.example.perfumaria_swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.perfumaria_swagger.model.Decant;

@RestController
@RequestMapping("/decantes")
@Tag(name = "Decantes", description = "Gerenciamento de decantes de fragrâncias")
public class DecanteController {

    // ========== GET ==========
    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna uma lista de todos os decantes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Decant.class))),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(501).build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna um decante específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Decante encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Decant.class))),
        @ApiResponse(responseCode = "404", description = "Decante não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }

    // ========== POST ==========
    @PostMapping
    @Operation(summary = "Criar novo", description = "Cria um novo decante")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Decante criado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Decant.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> save(@RequestBody Decant decant) {
        return ResponseEntity.status(501).build();
    }

    // ========== PUT ==========
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza um decante existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Decante atualizado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Decant.class))),
        @ApiResponse(responseCode = "404", description = "Decante não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Decant decant) {
        return ResponseEntity.status(501).build();
    }

    // ========== DELETE ==========
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar", description = "Remove um decante pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Decante deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Decante não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }
}
