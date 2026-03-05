package com.example.perfumaria_swagger.model;

public class ItemFamiliaAroma {
    private Integer id;
    private Integer IdFamiliaAroma;
    private Integer idItem;

    public ItemFamiliaAroma() {
    }

    public ItemFamiliaAroma(Integer IdFamiliaAroma, Integer idItem) {
        this.IdFamiliaAroma = IdFamiliaAroma;
        this.idItem = idItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdFamiliaAroma() {
        return IdFamiliaAroma;
    }

    public void setIdFamiliaAroma(Integer IdFamiliaAroma) {
        this.IdFamiliaAroma = IdFamiliaAroma;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }
}
