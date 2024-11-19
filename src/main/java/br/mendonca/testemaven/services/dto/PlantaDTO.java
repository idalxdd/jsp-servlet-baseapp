package br.mendonca.testemaven.services.dto;

import br.mendonca.testemaven.model.entities.Planta;

public class PlantaDTO {

    private String id;
    private String nomeCientifico;
    private String nomePopular;
    private String origem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    // Método para mapear Planta para PlantaDTO
    public static PlantaDTO plantaMapper(Planta planta) {
        PlantaDTO dto = new PlantaDTO();
        dto.setId(planta.getUuid());
        dto.setNomeCientifico(planta.getNomeCientifico());
        dto.setNomePopular(planta.getNomePopular());
        dto.setOrigem(planta.getOrigem());
        return dto;
    }
}