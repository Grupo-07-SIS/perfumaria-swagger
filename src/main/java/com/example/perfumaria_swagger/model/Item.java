package com.example.perfumaria_swagger.model;

public class Item {
    
    private Integer id;
    private Integer idCategoria;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private Boolean disponivel;
    private String status;
    private String dtAquisicao;
    private String tags;
    
    // Construtores
    public Item() {}
    
    public Item(Integer idCategoria, String nome, Integer quantidade) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.quantidade = quantidade;
    }
    
    public Item(Integer idCategoria, String nome, String descricao, Double preco, Integer quantidade, Boolean disponivel, String status, String tags) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        this.status = status;
        this.tags = tags;
    }
    
    // Getters e Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getIdCategoria() {
        return idCategoria;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Double getPreco() {
        return preco;
    }
    
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public Boolean getDisponivel() {
        return disponivel;
    }
    
    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDtAquisicao() {
        return dtAquisicao;
    }
    
    public void setDtAquisicao(String dtAquisicao) {
        this.dtAquisicao = dtAquisicao;
    }
    
    public String getTags() {
        return tags;
    }
    
    public void setTags(String tags) {
        this.tags = tags;
    }
}
