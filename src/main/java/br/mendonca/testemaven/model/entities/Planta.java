package br.mendonca.testemaven.model.entities;

public class Planta {

    private String uuid;
    private String nomeCientifico;
    private String nomePopular;
    private String origem;

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }
    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getNomePopular() {
        return nomePopular;
    }
    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
}