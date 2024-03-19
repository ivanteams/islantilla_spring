package com.soltel.islantilla.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soltel.islantilla.models.JoinReservasClientes;
import com.soltel.islantilla.models.ReservasId;
import com.soltel.islantilla.models.ReservasModel;
import com.soltel.islantilla.repositories.IReservasRepository;



@Service
public class ReservasService {
    private final IReservasRepository reservasRepository; 

    @Autowired
    public ReservasService(IReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    // Métodos de consulta
    public List<ReservasModel> findAllReservas() {
        return reservasRepository.findAll();
    }

    // OJO, el findById, aquí es diferente. Hay que meter el objeto ReservasId
    public Optional<ReservasModel> findReservaById (int hab, LocalDate entrada) {
        ReservasId id = new ReservasId(hab, entrada);
        return reservasRepository.findById(id);
    }

    // Métodos de accion: INSERT, UPDATE y DELETE
    // Este sirve tanto para INSERT como UPDATE
    public ReservasModel saveReserva (ReservasModel reserva) {
        return reservasRepository.save(reserva);
    }

    public void deleteReserva (int hab, LocalDate entrada) {
        ReservasId id = new ReservasId(hab, entrada);
        reservasRepository.deleteById(id);
    }

    // Creo un nuevo método para el JOIN
    public List<JoinReservasClientes> dameReservasClientes() {
        return reservasRepository.verReservasClientes();
    }


    // Creo un nuevo método para el JOIN filtrado por habitación
    public List<JoinReservasClientes> dameReservasClientes(int hab) {
        return reservasRepository.verReservasClientes(hab);
    }

}
