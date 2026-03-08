package com.example.perfumaria_swagger.model;

public class TipoCliente {

    private Integer id;
    private String tipoCliente;

    public TipoCliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente(Integer id, String tipoCliente) {
        this.id = id;
        this.tipoCliente = tipoCliente;
    }
}
