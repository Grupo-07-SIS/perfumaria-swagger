package com.example.perfumaria_swagger.controller;

import com.example.perfumaria_swagger.model.FamiliaAroma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/generos")
@Tag(name = "Famílias de Aroma", description = "API para gerenciamento de famílias/gêneros aromáticos")
public class FamiliaAromaController {
    
    @GetMapping
    @Operation(
        summary = "Listar todas as famílias de aroma",
        description = "Retorna uma lista com todas as famílias/gêneros aromáticos cadastrados"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de famílias de aroma retornada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Retorno ainda não definido")
    })
    public ResponseEntity<List<FamiliaAroma>> findAll() {
        return ResponseEntity.ok(List.of());
    }
}
