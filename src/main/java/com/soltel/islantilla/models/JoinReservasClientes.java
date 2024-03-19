package com.soltel.islantilla.models;

import java.time.LocalDate;

/**
 * Campos a introducir en el JOIN:
 * hab, entrada, nif, nombre, edad, precio, rutaPdf, opciones
 */

public class JoinReservasClientes {
    // Atributos del modelo (salida JSON)
    private int hab;
    private LocalDate entrada;
    private String nif;
    private String nombre;
    private int edad;
    private float precio;
    private String rutaPdf;
    private String opciones;
    
    // Constructores
	public JoinReservasClientes() {
	}

	public JoinReservasClientes(int hab, LocalDate entrada, String nif, String nombre, int edad, float precio,
			String rutaPdf, String opciones) {
		this.hab = hab;
		this.entrada = entrada;
		this.nif = nif;
		this.nombre = nombre;
		this.edad = edad;
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

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

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
