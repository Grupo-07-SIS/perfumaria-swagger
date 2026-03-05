package com.example.perfumaria_swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Família/Gênero aromático de um perfume")
public class FamiliaAroma {
    
    @Schema(description = "ID único da família aromática", example = "1")
    private Integer id;
    @Schema(description = "Nome da família aromática", example = "Floral")
    private String nome;
    
    public FamiliaAroma() {}
    
    public FamiliaAroma(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
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
