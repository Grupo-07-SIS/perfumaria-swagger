package com.example.perfumaria_swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.perfumaria_swagger.DTO.ItemRequest;
import com.example.perfumaria_swagger.DTO.ItemResponse;

@RestController
@RequestMapping("/items")
@Tag(name = "Items", description = "API para gerenciamento de itens/produtos")
public class ItemController {

    @PostMapping
    @Operation(
        summary = "Criar um novo item",
        description = "Cria um novo item de produto no sistema com as informações fornecidas"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Item criado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItemResponse.class))
        ),
        @ApiResponse(responseCode = "400", description = "Retorno ainda não definido", content = @Content()),
        @ApiResponse(responseCode = "409", description = "Retorno ainda não definido", content = @Content()),
        @ApiResponse(responseCode = "500", description = "Retorno ainda não definido", content = @Content())
    })
    public ResponseEntity<ItemResponse> save(@RequestBody ItemRequest item){
        return ResponseEntity.status(201).build();
    }
}
