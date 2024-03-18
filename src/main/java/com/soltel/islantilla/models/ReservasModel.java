package com.soltel.islantilla.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.time.LocalDate;

// Tenemos que definir cual será la clave principal en otra clase
// OJO! Solo para claves compuestas
@Entity
@Table(name = "reservas")
@IdClass(ReservasId.class)
public class ReservasModel {

    @Id
    private int hab;

    @Id
    private LocalDate entrada;

    @ManyToOne
    @JoinColumn(name = "nif", nullable = false)
    private ClientesModel cliente;

    @Column
    private float precio;

	// [#] Cambio 20240318
	@Column(name = "ruta_pdf")
	private String rutaPdf;

	// [#] Cambio 20240318
	@Column (name = "opciones")
	private String opciones;

    // Constructores
    public ReservasModel() {	}
    
	// [#] Cambio 20240318
	public ReservasModel(int hab, LocalDate entrada, ClientesModel cliente, float precio,
	String rutaPdf, String opciones) {
		super();
		this.hab = hab;
		this.entrada = entrada;
		this.cliente = cliente;
		this.precio = precio;
		this.rutaPdf = rutaPdf;
		this.opciones = opciones;
	}
	
	// Setter y Getter
	public int getHab() {
		return hab;
	}

	public void setHab(int hab) {
		this.hab = hab;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ClientesModel getCliente() {
		return cliente;
	}

	public void setCliente(ClientesModel cliente) {
		this.cliente = cliente;
	}

	// Nuevos Setter y Getter
	// [#] Cambio 20240318
	public String getRutaPdf() {
		return rutaPdf;
	}

	public void setRutaPdf(String rutaPdf) {
		this.rutaPdf = rutaPdf;
	}

	public String getOpciones() {
		return opciones;
	}

	public void setOpciones(String opciones) {
		this.opciones = opciones;
	}
    
	
	
    
    

}
