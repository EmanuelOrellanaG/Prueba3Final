package com.example.authenticationServ.Repository;

import com.example.authenticationServ.Entity.UsuarioAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuth, Long> {

    Optional<UsuarioAuth> findByUsername(String username);

    boolean existsByUsername(String username);

}
