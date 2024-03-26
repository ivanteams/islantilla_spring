package com.soltel.islantilla.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import com.soltel.islantilla.models.ClientesModel;
import com.soltel.islantilla.models.ReservasModel;
import com.soltel.islantilla.repositories.IClientesRepository;
import com.soltel.islantilla.repositories.IReservasRepository;
import java.time.LocalDate;

@Controller
public class DatosIniciales implements CommandLineRunner {

    @Autowired
    private IClientesRepository clientesRepository;

    @Autowired
    private IReservasRepository reservasRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear y guardar clientes
        ClientesModel cliente = new ClientesModel("12345678M", "Iván Rodríguez", 47, 0);
        clientesRepository.save(cliente);

        // Crear y guardar reservas con los nuevos campos
        
        ReservasModel reserva1 = new ReservasModel(120, LocalDate.parse("2024-03-30"), cliente, 75.50f, "ruta/pdf1.pdf", "spa");
        reservasRepository.save(reserva1);

        ReservasModel reserva2 = new ReservasModel(118, LocalDate.parse("2024-03-30"), cliente, 110.65f, "ruta/pdf2.pdf", "spa, masajes, balinesa");
        reservasRepository.save(reserva2);
    }
    
    
}
