package com.example.perfumaria_swagger.DTO;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados de requisição para criar um novo item")
public record ItemRequest(
    @Schema(description = "Nome do item", example = "Perfume Floral")
    String nome,
    @Schema(description = "ID da categoria do item", example = "1")
    Integer idCategoria,
    @Schema(description = "Quantidade disponível em estoque", example = "50")
    Integer quantidade,
    @Schema(description = "Preço do item em reais", example = "99.90")
    Double preco,
    @Schema(description = "Descrição detalhada do item", example = "Perfume de nível premium com notas florais")
    String descricao,
    @Schema(description = "Status do item", example = "ativo")
    String status,
    @Schema(description = "Indica se o item está disponível para venda", example = "true")
    Boolean disponivel,
    @Schema(description = "Data de aquisição do item", example = "2026-03-05")
    String dtAquisicao,
    @Schema(description = "Lista de IDs das famílias/gêneros aromáticos", example = "[1, 3, 5]")
    List<Integer> generos
) {
} 
