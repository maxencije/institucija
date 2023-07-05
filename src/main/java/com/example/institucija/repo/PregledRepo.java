package com.example.institucija.repo;

import com.example.institucija.domain.KontrolniPregled;
import com.example.institucija.domain.Pacijent;
import com.example.institucija.domain.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PregledRepo extends JpaRepository<Pregled, Long> {
    Pregled updatePregled(Pregled pregled);
    List<Pregled> getPreglediByPacijent(Long idPacijent);
    List<KontrolniPregled> getKontrolniPreglediByPregledId(Long id);
}
