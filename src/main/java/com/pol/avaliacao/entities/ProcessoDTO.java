package com.pol.avaliacao.entities;

import java.sql.Date;

public class ProcessoDTO {
	private Integer numero_processo;
	private String autor;
	private String reu;
	private String status;
	private Date data_criacao;

	public Integer getNumero_processo() {
		return numero_processo;
	}

	public void setNumero_processo(Integer numero_processo) {
		this.numero_processo = numero_processo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getReu() {
		return reu;
	}

	public void setReu(String reu) {
		this.reu = reu;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

}
