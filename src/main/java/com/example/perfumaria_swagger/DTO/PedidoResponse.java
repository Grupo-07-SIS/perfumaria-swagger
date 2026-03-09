package com.example.perfumaria_swagger.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados de resposta de um pedido")
public record PedidoResponse(

        @Schema(description = "ID do pedido", example = "1")
        Integer id,

        @Schema(description = "ID do cliente", example = "1")
        Integer clienteId,

        @Schema(description = "Nome do produto", example = "Bleu de Chanel")
        String produto,

        @Schema(description = "Quantidade", example = "2")
        Integer quantidade,

        @Schema(description = "Valor total", example = "799.90")
        Double valorTotal
) {
}