package com.soltel.islantilla.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;


/**
 * IMPORTANTE: Para las entidades el orden es:
 * 1) ClientesModel (la tabla principal)
 * 2) ReservasId (por la clave compuesta)
 * 3) ReservasModel (la tabla secundaria)
 */
@Entity
@Table(name = "clientes")
public class ClientesModel {

    // Atributos (campos BBDD)
    @Id
    private String nif;

    @Column (name = "nombre")
    private String nombre;

    @Column
    private int edad;

    // OJO, se guarda en la BBDD como 1 o 0 (tinyint)
    @Column
    private int sexo;

    // Hay que poner en la relación de tablas, OneToMay en el 1 y ManyToOne en el muchos
    // Aquí ponemos el OneToMany. El mapeo hay que ponerle el nombre de la entidad en singular
	// mappedBy = "cliente" debe coincidir con el nombre del campo en la tabla Reservas
    @OneToMany (mappedBy = "cliente")
	private Set<ReservasModel> reservas;
    
    // Setter y Getter
    
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

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	// Constructores
	public ClientesModel() {}
	
	public ClientesModel(String nif, String nombre, int edad, int sexo) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}
    
}
