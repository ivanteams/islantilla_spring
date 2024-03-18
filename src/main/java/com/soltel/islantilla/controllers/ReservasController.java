package com.soltel.islantilla.controllers;

import org.springframework.web.bind.annotation.RestController;

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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
