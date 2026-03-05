package com.example.perfumaria_swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Categoria de produtos de perfumaria")
public class Categoria {
    
    @Schema(description = "ID único da categoria", example = "1")
    private Integer id;
    @Schema(description = "Nome da categoria", example = "Perfumes Femininos")
    private String nome;
    
    
    public Categoria() {}
    

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}
