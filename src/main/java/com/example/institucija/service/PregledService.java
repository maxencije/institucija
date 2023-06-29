package com.example.institucija.service;

import com.example.institucija.domain.KontrolniPregled;
import com.example.institucija.domain.Pacijent;
import com.example.institucija.domain.Pregled;

import java.util.Date;
import java.util.List;

public interface PregledService {
    Pregled savePregled(Pregled pregled);
    Pregled getPregled(String id);
    void deletePregled(String id);
    Pregled updatePregled(Long id, Date datum);
    List<Pregled> getPregledi();
    List<Pregled> getPreglediByPacijent(Pacijent pacijent);
    List<KontrolniPregled> getKontrolniPreglediByPregled();
}
