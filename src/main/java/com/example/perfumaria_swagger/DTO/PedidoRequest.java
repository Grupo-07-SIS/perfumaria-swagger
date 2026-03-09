package com.example.perfumaria_swagger.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados de entrada para criação ou atualização de um pedido")
public record PedidoRequest(

        @Schema(description = "ID do cliente que realizou o pedido", example = "1")
        Integer clienteId,

        @Schema(description = "Nome do produto pedido", example = "Bleu de Chanel")
        String produto,

        @Schema(description = "Quantidade de itens", example = "2")
        Integer quantidade,

        @Schema(description = "Valor total do pedido", example = "799.90")
        Double valorTotal
) {
}