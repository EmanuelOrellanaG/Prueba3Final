package com.example.membresia.service;
import com.example.membresia.dto.MembresiaDTO;
import com.example.membresia.dto.UsuarioDTO;
import com.example.membresia.entity.Membresia;
import com.example.membresia.repository.MembresiaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MembresiaService {

    private final MembresiaRepository repository;
    private final WebClient webClient;

    public MembresiaService(MembresiaRepository repository, WebClient webClient) {
        this.repository = repository;
        this.webClient = webClient;
    }

    private Mono<UsuarioDTO> validarUsuario(Long userId) {

        return webClient.get()
                .uri("http://localhost:8082/api/usuarios/{id}", userId)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(),
                        response -> Mono.empty()
                )
                .bodyToMono(UsuarioDTO.class);
    }

    public Mono<Membresia> crear(MembresiaDTO dto) {

        return validarUsuario(dto.getUserId())
                .switchIfEmpty(Mono.error(
                        new RuntimeException("Usuario no existe, no se puede crear membresía")
                ))
                .flatMap(usuario -> {

                    Membresia membresia = new Membresia();
                    membresia.setUserId(dto.getUserId());
                    membresia.setNombre(dto.getNombre());
                    membresia.setDescripcion(dto.getDescripcion());
                    membresia.setPrecio(dto.getPrecio());
                    membresia.setDuracionDias(dto.getDuracionDias());
                    membresia.setActiva(dto.getActiva() != null ? dto.getActiva() : true);

                    return Mono.fromCallable(() -> repository.save(membresia));
                });
    }

    public List<Membresia> listar() {
        return repository.findAll();
    }

    public Membresia obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Mono<Membresia> actualizar(Long id, MembresiaDTO dto) {

        return validarUsuario(dto.getUserId())
                .switchIfEmpty(Mono.error(
                        new RuntimeException("Usuario no existe")
                ))
                .flatMap(usuario -> {

                    return Mono.fromCallable(() -> {

                        Membresia membresia = repository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Membresía no existe"));

                        membresia.setUserId(dto.getUserId());
                        membresia.setNombre(dto.getNombre());
                        membresia.setDescripcion(dto.getDescripcion());
                        membresia.setPrecio(dto.getPrecio());
                        membresia.setDuracionDias(dto.getDuracionDias());
                        membresia.setActiva(dto.getActiva());

                        return repository.save(membresia);
                    });
                });
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}