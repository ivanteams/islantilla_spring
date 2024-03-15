package com.soltel.islantilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soltel.islantilla.models.ClientesModel;
import com.soltel.islantilla.repositories.IClientesRepository;

@Service
public class ClientesService {
    private final IClientesRepository clientesRepository;

    // Constructor para cargar el repositorio que yo he hecho
    // Inyecto la dependencia
    @Autowired
    public ClientesService(IClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    // Creo mis propios métodos para hacer consultas
    // findAll -> SELECT * FROM Clientes
    // OJO! Este nombre es por convención: findAllClientes
    public List<ClientesModel> findAllClientes() {
        return clientesRepository.findAll();
    }

    // findBy(nif) -> SELECT * FROM Clientes WHERE nif = ?
    // Por convención: findByClientesByNif
    public Optional<ClientesModel> findByClientesByNif(String nif) {
        return clientesRepository.findById(nif);
    }

    // COMO ES VIERNES os voy a pasar los métodos para hacer el CRUD
    // insert, update, delete
    public ClientesModel saveCliente (ClientesModel cliente) {
        return clientesRepository.save(cliente);
    }

    public ClientesModel updateCliente (ClientesModel cliente) {
        return clientesRepository.save(cliente);
    }

    public void deleteCliente (String nif) {
        clientesRepository.deleteById(nif);
    }
}
