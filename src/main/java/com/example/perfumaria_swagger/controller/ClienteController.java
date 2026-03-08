package com.example.perfumaria_swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.perfumaria_swagger.model.Cliente;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Gerenciamento de clientes da perfumaria")
public class ClienteController {

    // ========== GET ==========
    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna uma lista de todos os clientes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(501).build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna um cliente específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }

    // ========== POST ==========
    @PostMapping
    @Operation(summary = "Criar novo", description = "Cria um novo cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> save(@RequestBody Cliente cliente) {
        return ResponseEntity.status(501).build();
    }

    // ========== PUT ==========
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza um cliente existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return ResponseEntity.status(501).build();
    }

    // ========== DELETE ==========
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar", description = "Remove um cliente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }
}
