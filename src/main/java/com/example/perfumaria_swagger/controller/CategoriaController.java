package com.example.perfumaria_swagger.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.perfumaria_swagger.model.Categoria;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorias", description = "API para gerenciamento de categorias de produtos")
public class CategoriaController {

    @GetMapping
    @Operation(
        summary = "Listar todas as categorias",
        description = "Retorna uma lista com todas as categorias de produtos disponíveis"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Retorno ainda não definido")
    })
    public ResponseEntity<List<Categoria>> findAll(){
        return ResponseEntity.ok(List.of());
    }
}
