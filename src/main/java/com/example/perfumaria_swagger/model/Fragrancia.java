package com.example.perfumaria_swagger.model;

import com.example.perfumaria_swagger.model.Enum.Concentracao;

import java.time.LocalDate;

public class Fragrancia {

    private Long id;
    private String nome;
    private Integer idMarca;
    private Marca marca;
    private Concentracao concentracao;
    private LocalDate dataAquisicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Concentracao getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(Concentracao concentracao) {
        this.concentracao = concentracao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }
}
