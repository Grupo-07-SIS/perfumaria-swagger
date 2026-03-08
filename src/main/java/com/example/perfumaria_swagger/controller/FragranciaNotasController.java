package com.example.perfumaria_swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.perfumaria_swagger.model.FragranciaNota;

@RestController
@RequestMapping("/fragrancias-notas")
@Tag(name = "Fragrâncias Notas", description = "Gerenciamento de notas olfativas em fragrâncias")
public class FragranciaNotasController {

    // ========== GET ==========
    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna uma lista de todas as fragrâncias com notas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FragranciaNota.class))),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(501).build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna um registro específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Registro encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FragranciaNota.class))),
        @ApiResponse(responseCode = "404", description = "Registro não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }

    // ========== POST ==========
    @PostMapping
    @Operation(summary = "Criar novo", description = "Cria um novo vínculo entre fragrância e nota")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Vínculo criado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FragranciaNota.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> save(@RequestBody FragranciaNota fragranciaNota) {
        return ResponseEntity.status(501).build();
    }

    // ========== PUT ==========
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza um vínculo existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vínculo atualizado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FragranciaNota.class))),
        @ApiResponse(responseCode = "404", description = "Vínculo não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody FragranciaNota fragranciaNota) {
        return ResponseEntity.status(501).build();
    }

    // ========== DELETE ==========
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar", description = "Remove um vínculo pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Vínculo deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Vínculo não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }
}
