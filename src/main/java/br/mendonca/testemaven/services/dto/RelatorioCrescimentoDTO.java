package br.mendonca.testemaven.services.dto;

import br.mendonca.testemaven.model.entities.RelatorioCrescimento;

public class RelatorioCrescimentoDTO {
    private int id;
    private int dataRegistro;  // Alterado para int
    private double altura;
    private String saude;
    private String observacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static RelatorioCrescimentoDTO mapper(RelatorioCrescimento relatorio) {
        RelatorioCrescimentoDTO dto = new RelatorioCrescimentoDTO();
        dto.setId(relatorio.getId());
        dto.setDataRegistro(relatorio.getDataRegistro());  // Alterado para int
        dto.setAltura(relatorio.getAltura());
        dto.setSaude(relatorio.getSaude());
        dto.setObservacoes(relatorio.getObservacoes());
        return dto;
    }
}
