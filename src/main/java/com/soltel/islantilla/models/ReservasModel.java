package com.soltel.islantilla.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "reservas")

public class ReservasModel {

    @Id
    private int hab;

    @Id
    private Date entrada;

    @ManyToOne
    @JoinColumn(name = "nif", nullable = false)
    private ClientesModel nif;

    @Column
    private float precio;

    // Constructores
    public ReservasModel() {	}
    
	public ReservasModel(int hab, Date entrada, ClientesModel nif, float precio) {
		super();
		this.hab = hab;
		this.entrada = entrada;
		this.nif = nif;
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

	public ClientesModel getNif() {
		return nif;
	}

	public void setNif(ClientesModel nif) {
		this.nif = nif;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
    
	
    
    

}
