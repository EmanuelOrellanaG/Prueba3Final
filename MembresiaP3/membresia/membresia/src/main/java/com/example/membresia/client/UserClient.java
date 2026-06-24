package com.example.membresia.client;

import com.example.membresia.dto.UsuarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserClient {

    private final WebClient webClient;

    public UserClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<UsuarioDTO> getUser(Long userId) {
        return webClient.get()
                .uri("/api/usuarios/{id}", userId)
                .retrieve()
                .bodyToMono(UsuarioDTO.class);
    }

    public Mono<Boolean> userExists(Long userId) {
        return getUser(userId)
                .map(user -> true)
                .onErrorReturn(false);
    }
}
