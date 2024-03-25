package com.soltel.islantilla.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soltel.islantilla.models.ClientesModel;
import com.soltel.islantilla.services.ClientesService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/clientes")
@Tag(name = "Endpoints Clientes")
public class ClientesController {

    // Atributo principal
    private final ClientesService clientesService;

    // Constructor
    public ClientesController (ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    // Método de consulta general
    // endpoint de ejemplo: http://localhost:8100/clientes/consultar
    /**
     * @description Endpoint para consultar
     * @todo Añadir control por Token
     * @return Entidad por consulta
     */
    @GetMapping("/consultar")
    public ResponseEntity<List<ClientesModel>> getAllClientes(){
        return ResponseEntity.ok(clientesService.findAllClientes());
    }

    // Método de consulta por campo
    // endpoint de ejemplo: http://localhost:8100/clientes/consultar/23456789g
    @GetMapping("/consultar/{nif}")
    public ResponseEntity<?> getClienteByNif(@PathVariable String nif) {
        // Convierto el nif en mayúsculas
        nif = nif.toUpperCase();
    	Optional<ClientesModel> cliente = clientesService.findByClientesByNif(nif);
        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    // Método para insertar
    // endpoint de ejemplo:  [POST] http://localhost:8100/clientes/insertar/23456789G/Sara/40/1
    @PostMapping("/insertar/{nif}/{nombre}/{edad}/{sexo}")
    public ResponseEntity<ClientesModel> createCliente (@PathVariable String nif, 
        @PathVariable String nombre, @PathVariable int edad, @PathVariable int sexo) {
            ClientesModel nuevoCliente  = new ClientesModel(nif, nombre, edad, sexo);
            ClientesModel guardaCliente = clientesService.saveCliente(nuevoCliente);
            return ResponseEntity.ok(guardaCliente);
    }

    // Método para actualizar
    // endpoint de ejemplo:  
    // [PUT] http://localhost:8100/clientes/actualizar/23456789G/Perico/38/0
    @PutMapping("/actualizar/{nif}/{nombre}/{edad}/{sexo}")
    public ResponseEntity<?> updateCliente(@PathVariable String nif, 
                @PathVariable String nombre, @PathVariable int edad, @PathVariable int sexo) {
        Optional<ClientesModel> cliente = clientesService.findByClientesByNif(nif);
        if(cliente.isPresent()) {
            ClientesModel clienteActualizado = cliente.get();
            clienteActualizado.setNombre(nombre);
            clienteActualizado.setEdad(edad);
            clienteActualizado.setSexo(sexo);
            ClientesModel guardaCliente = clientesService.updateCliente(clienteActualizado);
            return ResponseEntity.ok(guardaCliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }
    
    
    // Método para actualizar
    // endpoint de ejemplo:  
    // [PUT] http://localhost:8100/clientes/actualizar/23456789G/Federico/
    @PutMapping("/actualizar/{nif}/{nombre}/")
    public ResponseEntity<?> updateNombreCliente(@PathVariable String nif, 
                @PathVariable String nombre) {
        Optional<ClientesModel> cliente = clientesService.findByClientesByNif(nif);
        if(cliente.isPresent()) {
            ClientesModel clienteActualizado = cliente.get();
            clienteActualizado.setNombre(nombre);
            ClientesModel guardaCliente = clientesService.updateCliente(clienteActualizado);
            return ResponseEntity.ok(guardaCliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }
    
    // Método para eliminar
    // endpoint de ejemplo:  
    // [DELETE] http://localhost:8100/clientes/eliminar/23456789G
    @DeleteMapping("/eliminar/{nif}")
    public ResponseEntity<String> deleteCliente(@PathVariable String nif) {
        clientesService.deleteCliente(nif);
        return ResponseEntity.ok("Cliente eliminado!");
    }

}
