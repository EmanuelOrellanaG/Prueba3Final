package com.example.reserva.service;

import com.example.reserva.client.ClaseClient;
import com.example.reserva.client.UsuarioClient;
import com.example.reserva.dto.ClaseDTO;
import com.example.reserva.dto.ReservaDTO;
import com.example.reserva.dto.UsuarioDTO;
import com.example.reserva.entity.Reserva;
import com.example.reserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repo;

    @Autowired
    private ClaseClient claseClient;

    @Autowired
    private UsuarioClient usuarioClient;

    public Reserva crear(ReservaDTO dto, String username) {

        UsuarioDTO usuario = usuarioClient.obtenerPorUsername(username);

        ClaseDTO clase = claseClient.obtenerClase(dto.getClaseId());

        if (clase.getCuposDisponibles() <= 0) {
            throw new RuntimeException("No hay cupos");
        }

        claseClient.actualizarCupos(
                clase.getId(),
                clase.getCuposDisponibles() - 1
        );

        Reserva r = new Reserva();
        r.setUsername(username); // YA NO usuarioId
        r.setClaseId(dto.getClaseId());
        r.setFechaReserva(LocalDateTime.now());

        return repo.save(r);
    }

    public List<Reserva> listar() {
        return repo.findAll();
    }

    public Reserva buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
