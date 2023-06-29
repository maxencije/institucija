package com.example.institucija.repo;

import com.example.institucija.domain.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacijentRepo extends JpaRepository<Pacijent, Long> {
    Pacijent findByBrojKnjizice(String brojKnjizice);
}
