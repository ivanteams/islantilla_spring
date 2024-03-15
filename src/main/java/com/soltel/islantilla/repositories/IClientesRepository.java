package com.soltel.islantilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.soltel.islantilla.models.ClientesModel;

// Se hereda de JpaRepository y se especifica <Modelo, TipoPK)
@Repository
public interface IClientesRepository extends JpaRepository<ClientesModel, String> {

}
