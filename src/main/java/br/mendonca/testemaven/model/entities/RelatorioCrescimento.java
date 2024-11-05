package br.mendonca.testemaven.model.entities;

public class RelatorioCrescimento {
    private String id;
    private Planta planta; // Referência à entidade Planta id, planta, dataRegistro, altura, saude, observacoes
    private int dataRegistro;
    private double altura;
    private String saude;
    private String observacoes;


   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public int getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(int dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getSaude() {
        return saude;
    }

    public void setSaude(String saude) {
        this.saude = saude;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
