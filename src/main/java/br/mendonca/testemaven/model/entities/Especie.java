package br.mendonca.testemaven.model.entities;

public class Especie {
    
    private String uuid;
    private String nomeCientifico;
    private String nomePopular;
    private String familia;
    private String habitat;
    private String caracteristicas;
    private String necessidadeCuidados;
    private String statusConservacao;
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

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getNecessidadeCuidados() {
        return necessidadeCuidados;
    }

    public void setNecessidadeCuidados(String necessidadeCuidados) {
        this.necessidadeCuidados = necessidadeCuidados;
    }

    public String getStatusConservacao() {
        return statusConservacao;
    }

    public void setStatusConservacao(String statusConservacao) {
        this.statusConservacao = statusConservacao;
    }
    
}