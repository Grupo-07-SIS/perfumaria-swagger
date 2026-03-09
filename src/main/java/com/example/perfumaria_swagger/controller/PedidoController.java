package com.example.perfumaria_swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import com.example.perfumaria_swagger.DTO.PedidoRequest;
import com.example.perfumaria_swagger.DTO.PedidoResponse;

@RestController
@RequestMapping("/pedidos")
@Tag(name = "Pedidos", description = "API para gerenciamento de pedidos")
public class PedidoController {

    @GetMapping
    @Operation(
            summary = "Listar pedidos",
            description = "Retorna uma lista de todos os pedidos cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de pedidos retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PedidoResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content())
    })
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(501).build();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar pedido por ID",
            description = "Retorna um pedido específico pelo ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Pedido encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PedidoResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content())
    })
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }

    @PostMapping
    @Operation(
            summary = "Criar pedido",
            description = "Cria um novo pedido no sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Pedido criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PedidoResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content())
    })
    public ResponseEntity<?> save(@RequestBody PedidoRequest request) {
        return ResponseEntity.status(501).build();
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar pedido",
            description = "Atualiza um pedido existente"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Pedido atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PedidoResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content()),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content())
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody PedidoRequest request) {
        return ResponseEntity.status(501).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar pedido",
            description = "Remove um pedido pelo ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pedido deletado com sucesso", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content())
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(501).build();
    }
}
