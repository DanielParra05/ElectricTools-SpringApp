package com.spring.electric.tools.models.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "ORDEN")
public class Orden implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ORDEN")
	private Long idOrden;
	@Column(name = "FECHA_ENTRADA")
	private LocalDate fechaEntrada;
	@Column(name = "FECHA_SALIDA",nullable = true)
	private LocalDate fechaSalida;
	@ManyToOne
	@JoinColumn(name = "cliente",foreignKey = @ForeignKey(name = "FK_CLIENTE"))
	private Cliente cliente;
	@Column(name = "NOMBRE_ARTICULO")
	private String nombreArticulo;
	@Column(name = "MARCA_ARTICULO")
	private String marcaArticulo;
	@Column(name = "MODELO_ARTICULO")
	private String modeloArticulo;
	@Column(name = "SERIAL_ARTICULO")
	private String serialArticulo;
	@Column(name= "PROBLEMA_REPORTADO",nullable = false)
	private String problemaReportado;
	@Column(name = "VALOR",nullable = true)
	private String valor;

	public Long getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Long idOrden) {
		this.idOrden = idOrden;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public String getMarcaArticulo() {
		return marcaArticulo;
	}

	public void setMarcaArticulo(String marcaArticulo) {
		this.marcaArticulo = marcaArticulo;
	}

	public String getModeloArticulo() {
		return modeloArticulo;
	}

	public void setModeloArticulo(String modeloArticulo) {
		this.modeloArticulo = modeloArticulo;
	}

	public String getSerialArticulo() {
		return serialArticulo;
	}

	public void setSerialArticulo(String serialArticulo) {
		this.serialArticulo = serialArticulo;
	}

	public String getProblemaReportado() {
		return problemaReportado;
	}

	public void setProblemaReportado(String problemaReportado) {
		this.problemaReportado = problemaReportado;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}