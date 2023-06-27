package com.example.institucija.Repo;

import com.example.institucija.Domain.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacijentRepo extends JpaRepository<Pacijent, Long> {
}
