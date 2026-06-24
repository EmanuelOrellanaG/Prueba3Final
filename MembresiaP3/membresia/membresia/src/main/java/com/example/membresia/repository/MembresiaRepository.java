package com.example.membresia.repository;

import com.example.membresia.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



    @Repository
    public interface MembresiaRepository extends JpaRepository<Membresia, Long> {
    }
    

