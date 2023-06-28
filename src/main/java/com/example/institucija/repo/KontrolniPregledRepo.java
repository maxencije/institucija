package com.example.institucija.repo;

import com.example.institucija.domain.KontrolniPregled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontrolniPregledRepo extends JpaRepository<KontrolniPregled, Long> {
}
