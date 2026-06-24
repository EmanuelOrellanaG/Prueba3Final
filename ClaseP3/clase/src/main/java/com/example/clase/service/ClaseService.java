package com.example.clase.service;

import com.example.clase.dto.ClaseDTO;
import com.example.clase.entity.Clase;
import com.example.clase.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository repo;

    public Clase crear(ClaseDTO dto){
        Clase c = new Clase();
        c.setNombre(dto.getNombre());
        c.setDescripcion(dto.getDescripcion());
        c.setEntrenador(dto.getEntrenador());
        c.setHorario(dto.getHorario());
        c.setCapacidadMaxima(dto.getCapacidadMaxima());
        c.setCuposDisponibles(dto.getCapacidadMaxima());

        return repo.save(c);
    }

    public List<Clase> listar(){
        return repo.findAll();
    }

    public Clase obtenerPorId(Long id){
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        repo.deleteById(id);
    }
}
