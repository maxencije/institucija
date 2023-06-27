package com.example.institucija.Repo;

import com.example.institucija.Domain.KontrolniPregled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontrolniPregledRepo extends JpaRepository<KontrolniPregled, Long> {
}
