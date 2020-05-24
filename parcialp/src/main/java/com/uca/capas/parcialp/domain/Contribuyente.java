package com.uca.capas.parcialp.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(generator="contribuyente_c_contribuyente_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "contribuyente_c_contribuyente_seq", sequenceName = "public.contribuyente_c_contribuyente_seq", allocationSize = 1)	
	@Column(name="c_contribuyente")
	private Integer codigoContribuyente;
	
	@Size(message="El campo no debe de tener más de 30 caracteres", max=30)
	@NotEmpty(message="El campo no debe estar vacío")
	@Column(name="s_nombre")
	private String nombre;
	
	@Size(message="El campo no debe de tener más de 30 caracteres", max=30)
	@NotEmpty(message="El campo no debe estar vacío")
	@Column(name="s_apellido")
	private String apellido;
	
	@NotEmpty(message="nit no puede estar vacío")
	@Pattern(regexp="\\d{14}", message="Debe ser 14 digitos exactos")
	@Column(name="s_nit")
	String nit;
	
	@NotNull(message = "El campo Fecha no puede quedar vacio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "f_fecha")
	private Date fecha;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name="c_importancia")
	private Importancia importancia;

		
	public Integer getCodigoContribuyente() {
		return codigoContribuyente;
	}


	public void setCodigoContribuyente(Integer codigoContribuyente) {
		this.codigoContribuyente = codigoContribuyente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNit() {
		return nit;
	}


	public void setNit(String nit) {
		this.nit = nit;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Importancia getImportancia() {
		return importancia;
	}


	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}


	public String getFechaDelegate()
	{
		if(this.fecha== null)
		{
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String shortdate = sdf.format(this.fecha.getTime());
			return shortdate;
		}
	}
}
