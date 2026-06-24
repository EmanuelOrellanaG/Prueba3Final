package com.example.rutina.service;

import com.example.rutina.client.EjercicioClient;
import com.example.rutina.client.UsuarioClient;
import com.example.rutina.dto.RutinaDTO;
import com.example.rutina.entity.Rutina;
import com.example.rutina.repository.RutinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {

    private final RutinaRepository repository;
    private final UsuarioClient usuarioClient;
    private final EjercicioClient ejercicioClient;


    public RutinaService(RutinaRepository repository, UsuarioClient usuarioClient, EjercicioClient ejercicioClient){
        this.repository = repository;
        this.ejercicioClient = ejercicioClient;
        this.usuarioClient = usuarioClient;
    }

    public Rutina crear(RutinaDTO dto){
        Rutina rutina = new Rutina();

        usuarioClient.obtenerUsuario(dto.getUsuarioId());
        ejercicioClient.obtenerEjercicio(dto.getEjercicioId());

        rutina.setNombre(dto.getNombre());
        rutina.setDecripcion(dto.getDescripcion());
        rutina.setNivel(dto.getNivel());
        rutina.setDuracionSemanas(dto.getDuracionSemanas());

        rutina.setUsuarioId(dto.getUsuarioId());
        rutina.setEjercicioId(dto.getEjercicioId());

        return repository.save(rutina);
    }

    public List<Rutina> listar(){
        return repository.findAll();
    }

    public Rutina obtener (Long id){
        return repository.findById(id).orElse(null);
    }

    public Rutina actualizar(Long id, RutinaDTO dto) {

        Rutina rutina = repository.findById(id).orElse(null);

        if (rutina == null) {
            return null;
        }


        usuarioClient.obtenerUsuario(dto.getUsuarioId());
        ejercicioClient.obtenerEjercicio(dto.getEjercicioId());

        rutina.setNombre(dto.getNombre());
        rutina.setDecripcion(dto.getDescripcion());
        rutina.setNivel(dto.getNivel());
        rutina.setDuracionSemanas(dto.getDuracionSemanas());

        rutina.setUsuarioId(dto.getUsuarioId());
        rutina.setEjercicioId(dto.getEjercicioId());

        return repository.save(rutina);
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }
}
