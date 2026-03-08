package com.example.perfumaria_swagger.model;

import java.math.BigDecimal;

public class Decant {

    private Long idFragrancia;
    private BigDecimal capacidadeMl;
    private BigDecimal preco;

    public Long getIdFragrancia() {
        return idFragrancia;
    }

    public void setIdFragrancia(Long idFragrancia) {
        this.idFragrancia = idFragrancia;
    }

    public BigDecimal getCapacidadeMl() {
        return capacidadeMl;
    }

    public void setCapacidadeMl(BigDecimal capacidadeMl) {
        this.capacidadeMl = capacidadeMl;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
