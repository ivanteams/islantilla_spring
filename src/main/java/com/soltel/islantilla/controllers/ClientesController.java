package com.soltel.islantilla.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soltel.islantilla.models.ClientesModel;
import com.soltel.islantilla.services.ClientesService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    // Atributo principal
    private final ClientesService clientesService;

    // Constructor
    public ClientesController (ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    // Método
    // endpoint de ejemplo: http://localhost:8100/clientes/consultar
    @GetMapping("/consultar")
    public ResponseEntity<List<ClientesModel>> getAllClientes(){
        return ResponseEntity.ok(clientesService.findAllClientes());
    }

    // endpoint de ejemplo: http://localhost:8100/clientes/insertar/12345667M/Iván/47/0
    @PostMapping("/insertar/{nif}/{nombre}/{edad}/{sexo}")
    public ResponseEntity<ClientesModel> createCliente (@PathVariable String nif, 
        @PathVariable String nombre, @PathVariable int edad, @PathVariable int sexo) {
            ClientesModel nuevoCliente  = new ClientesModel(nif, nombre, edad, sexo);
            ClientesModel guardaCliente = clientesService.saveCliente(nuevoCliente);
            return ResponseEntity.ok(guardaCliente);
        }


}
