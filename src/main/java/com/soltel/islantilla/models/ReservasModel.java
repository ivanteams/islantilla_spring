package com.soltel.islantilla.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.util.Date;

// Tenemos que definir cual será la clave principal en otra clase
// OJO! Solo para claves compuestas
@Entity
@Table(name = "reservas")
@IdClass(ReservasId.class)
public class ReservasModel {

    @Id
    private int hab;

    @Id
    private Date entrada;

    @ManyToOne
    @JoinColumn(name = "nif", nullable = false)
    private ClientesModel cliente;

    @Column
    private float precio;

    // Constructores
    public ReservasModel() {	}
    
	public ReservasModel(int hab, Date entrada, ClientesModel cliente, float precio) {
		super();
		this.hab = hab;
		this.entrada = entrada;
		this.cliente = cliente;
		this.precio = precio;
	}
	
	// Setter y Getter
	public int getHab() {
		return hab;
	}

	public void setHab(int hab) {
		this.hab = hab;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}



	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
    
	
    
    

}
