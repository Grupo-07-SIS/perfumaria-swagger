package com.example.perfumaria_swagger.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import com.example.perfumaria_swagger.model.Fornecedor;

@RestController
@RequestMapping("/fornecedores")
@Tag(name = "Fornecedores", description = "API para gerenciamento de fornecedores da perfumaria")
public class FornecedorController {

    @GetMapping
    @Operation(
            summary = "Listar todos os fornecedores",
            description = "Retorna uma lista com todos os fornecedores cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<List<Fornecedor>> findAll() {
        return ResponseEntity.ok(List.of());
    }

    @PostMapping
    @Operation(
            summary = "Cadastrar fornecedor",
            description = "Cria um novo fornecedor no sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Fornecedor criado com sucesso",
                    content = @Content(schema = @Schema(implementation = Fornecedor.class))
            ),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> save(

            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados do fornecedor a ser cadastrado",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Fornecedor.class))
            )
            @RequestBody Fornecedor fornecedor
    ) {
        return ResponseEntity.status(501).build();
    }
}