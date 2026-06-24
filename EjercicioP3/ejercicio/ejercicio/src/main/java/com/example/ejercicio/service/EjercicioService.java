package com.example.ejercicio.service;
import com.example.ejercicio.dto.EjercicioDTO;
import com.example.ejercicio.entity.Ejercicio;
import com.example.ejercicio.repository.EjercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {

    private final EjercicioRepository repository;

    public EjercicioService(EjercicioRepository repository) {
        this.repository = repository;
    }

    public Ejercicio crear(EjercicioDTO dto) {

        Ejercicio e = new Ejercicio();
        e.setNombre(dto.getNombre());
        e.setGrupoMuscular(dto.getGrupoMuscular());
        e.setSeries(dto.getSeries());
        e.setRepeticiones(dto.getRepeticiones());
        e.setDescripcion(dto.getDescripcion());

        return repository.save(e);
    }

    public List<Ejercicio> listar() {
        return repository.findAll();
    }

    public Ejercicio obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Ejercicio actualizar(Long id, EjercicioDTO dto) {

        Ejercicio e = repository.findById(id).orElse(null);
        if (e == null) return null;

        e.setNombre(dto.getNombre());
        e.setGrupoMuscular(dto.getGrupoMuscular());
        e.setSeries(dto.getSeries());
        e.setRepeticiones(dto.getRepeticiones());
        e.setDescripcion(dto.getDescripcion());

        return repository.save(e);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}