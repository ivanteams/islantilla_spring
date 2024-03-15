package com.soltel.islantilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soltel.islantilla.models.ReservasId;
import com.soltel.islantilla.models.ReservasModel;

// Se hereda de JpaRepository y dentro de <> se pone <Modelo, Clase IDModelo>
@Repository
public interface IReservasRepository extends JpaRepository <ReservasModel, ReservasId>{

}
