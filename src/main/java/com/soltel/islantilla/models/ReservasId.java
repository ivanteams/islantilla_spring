package com.soltel.islantilla.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ReservasId implements Serializable{
    private int hab;
    private LocalDate entrada;
    
    // Constructores
    public ReservasId() {}
    
	public ReservasId(int hab, LocalDate entrada) {
		super();
		this.hab = hab;
		this.entrada = entrada;
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

	@Override
	public int hashCode() {
		return Objects.hash(entrada, hab);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservasId other = (ReservasId) obj;
		return Objects.equals(entrada, other.entrada) && hab == other.hab;
	}
	
	

    
}
