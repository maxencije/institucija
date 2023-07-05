package com.example.institucija.service;

import com.example.institucija.domain.KontrolniPregled;
import com.example.institucija.domain.Pacijent;
import com.example.institucija.domain.Pregled;

import java.util.Date;
import java.util.List;

public interface PregledService {
    Pregled savePregled(Pregled pregled);
    Pregled getPregled(Long id);
    void deletePregled(Long id);
    void updatePregled(Long id, Date datum);
    List<Pregled> getPregledi();
    List<Pregled> getPreglediByPacijent(Long idPacijent);
    List<KontrolniPregled> getKontrolniPreglediByPregledId(Long id);
}
