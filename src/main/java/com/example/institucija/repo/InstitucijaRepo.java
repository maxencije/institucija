package com.example.institucija.repo;

import com.example.institucija.domain.Institucija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstitucijaRepo extends JpaRepository<Institucija, Long> {
    Optional<Institucija> findByNaziv(String naziv);
}
