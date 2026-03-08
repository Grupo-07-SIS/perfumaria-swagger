package com.example.perfumaria_swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Fornecedor de produtos da perfumaria")
public class Fornecedor {

    @Schema(description = "Nome do fornecedor", example = "Importados Brasil")
    private String nome;

    @Schema(description = "Quantidade mínima de pedido", example = "10")
    private int quantidadeMinima;

    @Schema(description = "Data de cadastro", example = "2026-03-07")
    private String dataCadastro;

    @Schema(description = "ID do tipo de entrega", example = "2")
    private int tipoEntregaId;

    @Schema(description = "Fornecedor vende body splash", example = "true")
    private boolean bodySplash;

    @Schema(description = "Fornecedor vende frascos", example = "false")
    private boolean frasco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getTipoEntregaId() {
        return tipoEntregaId;
    }

    public void setTipoEntregaId(int tipoEntregaId) {
        this.tipoEntregaId = tipoEntregaId;
    }

    public boolean isBodySplash() {
        return bodySplash;
    }

    public void setBodySplash(boolean bodySplash) {
        this.bodySplash = bodySplash;
    }

    public boolean isFrasco() {
        return frasco;
    }

    public void setFrasco(boolean frasco) {
        this.frasco = frasco;
    }
}