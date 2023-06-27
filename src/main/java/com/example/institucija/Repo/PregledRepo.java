package com.example.institucija.Repo;

import com.example.institucija.Domain.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PregledRepo extends JpaRepository<Pregled, Long> {
}
