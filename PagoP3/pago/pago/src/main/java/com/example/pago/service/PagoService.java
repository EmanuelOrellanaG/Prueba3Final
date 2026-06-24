package com.example.pago.service;
import com.example.pago.dto.PagoDTO;
import com.example.pago.entity.Pago;
import com.example.pago.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    private final PagoRepository repository;

    public PagoService(PagoRepository repository) {
        this.repository = repository;
    }

    public Pago crear(PagoDTO dto) {

        Pago pago = new Pago();
        pago.setUsuarioId(dto.getUsuarioId());
        pago.setMembresiaId(dto.getMembresiaId());
        pago.setMonto(dto.getMonto());
        pago.setFechaPago(dto.getFechaPago());
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setEstado(dto.getEstado());

        return repository.save(pago);
    }

    public List<Pago> listar() {
        return repository.findAll();
    }

    public Pago obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pago actualizar(Long id, PagoDTO dto) {

        Pago pago = repository.findById(id).orElse(null);

        if (pago == null) {
            return null;
        }

        pago.setUsuarioId(dto.getUsuarioId());
        pago.setMembresiaId(dto.getMembresiaId());
        pago.setMonto(dto.getMonto());
        pago.setFechaPago(dto.getFechaPago());
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setEstado(dto.getEstado());

        return repository.save(pago);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}