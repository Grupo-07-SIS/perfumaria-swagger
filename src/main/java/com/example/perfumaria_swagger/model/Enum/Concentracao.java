package com.example.perfumaria_swagger.model.Enum;

public enum Concentracao {

    EDP("EDP"),
    EDT("EDT"),
    EDC("EDC"),
    EAU_FRAICHE("EAU_FRAICHE");

    @SuppressWarnings("unused")
    private final String valorDb;

    Concentracao(String valorDb) {
        this.valorDb = valorDb;
    }
}
