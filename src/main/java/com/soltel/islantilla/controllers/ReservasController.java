package com.soltel.islantilla.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.soltel.islantilla.models.ClientesModel;
import com.soltel.islantilla.models.JoinReservasClientes;
import com.soltel.islantilla.models.ReservasModel;
import com.soltel.islantilla.services.ClientesService;
import com.soltel.islantilla.services.ReservasService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController

@RequestMapping("/reservas")
public class ReservasController {

    // Como atributos, introduzco los servicios de ambas tablas
    private final ClientesService clientesService;
    private final ReservasService reservasService;

    // Inyecto en la clase ambos servicios en el constructor
    @Autowired
    public ReservasController (ClientesService clientesService,
    ReservasService reservasService) {
        this.clientesService = clientesService;
        this.reservasService = reservasService;
    }

    // Método para consultar
    // Equivale SELECT * FROM reservas
    // Endpoint de ejemplo: [GET] http://localhost:8100/reservas/consultar
    @GetMapping("/consultar")
    public ResponseEntity<List<ReservasModel>> getAllReservas() {
        return ResponseEntity.ok(reservasService.findAllReservas());
    }
    
    // Método para consultar por clave principal (hab, entrada)
    // Endpoint de ejemplo: [GET] http://localhost:8100/reservas/consultar/118/2024-03-23
    // OJO, hay que convertir la fecha -> @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)) 
    @GetMapping("/consultar/{hab}/{entrada}")
    public ResponseEntity<?> getReservaById (@PathVariable int hab, 
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada) {
        Optional<ReservasModel> reserva = reservasService.findReservaById(hab, entrada);
        if(reserva.isPresent()) {
            return ResponseEntity.ok(reserva.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Reserva no encontrada!");
        }
    }
    
    // Método para insertar
    // Endpoint de ejemplo: [POST] 
    // http://localhost:8100/reservas/insertar/118/2024-04-06/12345678M/110.65/reserva_20240318_003.pdf/spa,masajes,balinesa
    @PostMapping("/insertar/{hab}/{entrada}/{nif}/{precio}/{rutaPdf}/{opciones}")
    public ResponseEntity<?> createReserva (@PathVariable int hab, @PathVariable LocalDate entrada,
        @PathVariable String nif, @PathVariable float precio, 
        @PathVariable String rutaPdf, @PathVariable String opciones) {
        
        // 1º Busco si la reserva YA existe
        Optional<ReservasModel> reserva = reservasService.findReservaById(hab, entrada);
        // 2º Tengo que buscar el cliente a partir del nif
        Optional<ClientesModel> clienteBuscado = clientesService.findByClientesByNif(nif);

        if(reserva.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reserva existente!");
        } else if(clienteBuscado.isPresent()){
            ReservasModel nuevaReserva = new ReservasModel();
            ClientesModel cliente = clienteBuscado.get();

            // Hago la asignación de todos los atributos (incluido el objeto Cliente)
            nuevaReserva.setHab(hab);
            nuevaReserva.setEntrada(entrada);
            nuevaReserva.setPrecio(precio);
            nuevaReserva.setCliente(cliente);
            nuevaReserva.setRutaPdf(rutaPdf);
            nuevaReserva.setOpciones(opciones);

            // Tengo que hacer la INSERCIÓN!!
            ReservasModel reservaGuardada = reservasService.saveReserva(nuevaReserva);
            return ResponseEntity.ok(reservaGuardada);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente no existe");
        } 
    }
    
    
    // Método para actualizar
    // NOTA: Ejecutar antes [POST] http://localhost:8100/clientes/insertar/23456789G/Sara/40/1
    // Endpoint de ejemplo: [PUT] 
    // http://localhost:8100/reservas/actualizar/118/2024-04-06/23456789G/90.55/reserva_20240319_001.pdf/spa,masajes,balinesa
    @PutMapping("/actualizar/{hab}/{entrada}/{nif}/{precio}/{rutaPdf}/{opciones}")
    public ResponseEntity<?> updateReserva (@PathVariable int hab, @PathVariable LocalDate entrada,
        @PathVariable String nif, @PathVariable float precio, 
        @PathVariable String rutaPdf, @PathVariable String opciones) {
        
        // 1º Busco si la reserva YA existe
        Optional<ReservasModel> reserva = reservasService.findReservaById(hab, entrada);
        // 2º Tengo que buscar el cliente a partir del nif
        Optional<ClientesModel> clienteBuscado = clientesService.findByClientesByNif(nif);

        if(!reserva.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reserva NO existe!");
        } else if(clienteBuscado.isPresent()){
            ReservasModel reservaActualizada = reserva.get();
            ClientesModel cliente = clienteBuscado.get();

            // Hago la asignación de todos los atributos (incluido el objeto Cliente)
            reservaActualizada.setPrecio(precio);
            reservaActualizada.setCliente(cliente);
            reservaActualizada.setRutaPdf(rutaPdf);
            reservaActualizada.setOpciones(opciones);

            // Tengo que hacer la INSERCIÓN!!
            ReservasModel reservaGuardada = reservasService.saveReserva(reservaActualizada);
            return ResponseEntity.ok(reservaGuardada);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente no existe");
        } 
    }
    
    // Método para borrar
    // Endpoint de ejemplo: [DELETE] http://localhost:8100/reservas/eliminar/120/2024-03-28
    @DeleteMapping("/eliminar/{hab}/{entrada}")
    public ResponseEntity<?> deleteReserva (@PathVariable int hab, @PathVariable LocalDate entrada) {

        // 1º Busco si la reserva YA existe
        Optional<ReservasModel> reserva = reservasService.findReservaById(hab, entrada);

        if(!reserva.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reserva NO existe!");
        } else {
            // Ejecuto el borrado si la reserva existe
            reservasService.deleteReserva(hab, entrada);
            return ResponseEntity.ok("Reserva eliminada!");
        } 
    }

    // Método para hacer un JOIN con ambas tablas
    // Endpoint de ejemplo: [GET] http://localhost:8100/reservas/consultar/join
    @GetMapping("/consultar/join")
    public ResponseEntity<List<JoinReservasClientes>> consultarReservasClientes() {
        List<JoinReservasClientes> listaReservas = reservasService.dameReservasClientes();
        return ResponseEntity.ok(listaReservas);
    }

    // Método para hacer un JOIN con ambas tablas filtrado por un parámetro
    // Endpoint de ejemplo: [GET] http://localhost:8100/reservas/consultar/join/118
    @GetMapping("/consultar/join/{hab}")
    public ResponseEntity<List<JoinReservasClientes>> consultarReservasClientes(@PathVariable int hab) {
        List<JoinReservasClientes> listaReservas = reservasService.dameReservasClientes(hab);
        return ResponseEntity.ok(listaReservas);
    }
    

}
