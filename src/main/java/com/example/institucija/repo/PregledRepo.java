package com.example.institucija.repo;

import com.example.institucija.domain.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PregledRepo extends JpaRepository<Pregled, Long> {
}
