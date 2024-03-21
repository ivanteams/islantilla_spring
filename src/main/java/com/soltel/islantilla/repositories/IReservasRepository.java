package com.soltel.islantilla.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soltel.islantilla.models.JoinReservasClientes;
import com.soltel.islantilla.models.ReservasId;
import com.soltel.islantilla.models.ReservasModel;

// Se hereda de JpaRepository y dentro de <> se pone <Modelo, Clase IDModelo>
@Repository
public interface IReservasRepository extends JpaRepository <ReservasModel, ReservasId>{
	
    /*
     * Creamos una consulta personalizada (JOIN) en SQL seria asi:
     * SELECT r.hab, r.entrada, c.nif, c.nombre, c.edad, r.precio, r.ruta_pdf, r.opciones
     * FROM reservas r JOIN clientes c
     * WHERE r.nif = c.nif
     */

     /*
      * Vamos a usar una consulta JPQL (Java Persistence Query Language)
      * Alias para clientes -> c; Alias para Reservas -> r
      * Campos: hab, entrada, nif, nombre, edad, precio, rutaPdf, opciones
      * r.cliente es el atributo de ReservasModel de la unión entre tablas
      *
      * OJO: Hay que poner la ruta COMPLETA del modelo del JOIN:
      * com.soltel.islantilla.models.JoinReservasClientes
      */ 
	@Query( "SELECT new com.soltel.islantilla.models.JoinReservasClientes(" +
		     "r.hab, r.entrada, c.nif, c.nombre, c.edad, " +
             "r.precio, r.rutaPdf, r.opciones) " +              // Agregado espacio aquí después de )
		     "FROM ReservasModel r JOIN r.cliente c")
		 
		    List<JoinReservasClientes> verReservasClientes();

    @Query( "SELECT new com.soltel.islantilla.models.JoinReservasClientes(" +
    "r.hab, r.entrada, c.nif, c.nombre, c.edad, " +
    "r.precio, r.rutaPdf, r.opciones) " +              // Agregado espacio aquí después de )
    "FROM ReservasModel r JOIN r.cliente c " +
    " WHERE r.hab = :hab")
        
           List<JoinReservasClientes> 
                verReservasClientes(@Param("hab") int hab);
}
