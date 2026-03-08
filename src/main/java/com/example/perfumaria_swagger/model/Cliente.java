package com.example.perfumaria_swagger.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private int idade;
    private String endereco;
    private String dataCadastro;
    private String genero;
    private List<String> interesses = new ArrayList<>();
    private Integer tipoClienteId;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String telefone, int idade, String endereco, String dataCadastro, String genero, List<String> interesses, Integer tipoClienteId) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
        this.genero = genero;
        this.interesses = interesses;
        this.tipoClienteId = tipoClienteId;
    }

    public Integer getTipoClienteId() {
        return tipoClienteId;
    }

    public void setTipoClienteId(Integer tipoClienteId) {
        this.tipoClienteId = tipoClienteId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }
}
