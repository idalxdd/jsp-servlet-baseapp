package br.mendonca.testemaven.model.entities;

public class Adocao {

	private String uuid;
	private String usuarioId;
	private String plantaId;
	private String dataAdocao;
	private String statusAdocao;
	private String lembreteAdocao;
	
	public Adocao(String uuid, String usuarioId, String plantaId, String dataAdocao, String statusAdocao,
			String lembreteAdocao) {
		super();
		this.uuid = uuid;
		this.usuarioId = usuarioId;
		this.plantaId = plantaId;
		this.dataAdocao = dataAdocao;
		this.statusAdocao = statusAdocao;
		this.lembreteAdocao = lembreteAdocao;
	}
	
	public Adocao() {}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getPlantaId() {
		return plantaId;
	}

	public void setPlantaId(String plantaId) {
		this.plantaId = plantaId;
	}

	public String getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(String dataAdocao) {
		this.dataAdocao = dataAdocao;
	}

	public String getStatusAdocao() {
		return statusAdocao;
	}

	public void setStatusAdocao(String statusAdocao) {
		this.statusAdocao = statusAdocao;
	}

	public String getLembreteAdocao() {
		return lembreteAdocao;
	}

	public void setLembreteAdocao(String lembreteAdocao) {
		this.lembreteAdocao = lembreteAdocao;
	}

	
	
	
	
	

}
