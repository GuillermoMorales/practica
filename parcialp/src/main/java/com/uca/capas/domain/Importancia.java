package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(schema="public", name="importancia")
public class Importancia {
	
	@Id
	@Column(name="c_importancia")
	private Integer codigoImportancia;
	
	@Column(name="s_importancia")
	private String  importancia;
	
	@OneToMany(mappedBy="contribuyente",fetch=FetchType.EAGER)
	private List<Contribuyente> contribuyentes;

	public Integer getCodigoImportancia() {
		return codigoImportancia;
	}

	public void setCodigoImportancia(Integer codigoImportancia) {
		this.codigoImportancia = codigoImportancia;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

	public List<Contribuyente> getContribuyentes() {
		return contribuyentes;
	}

	public void setContribuyentes(List<Contribuyente> contribuyentes) {
		this.contribuyentes = contribuyentes;
	}
	
	

}
