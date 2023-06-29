package com.example.institucija.service;

import com.example.institucija.domain.KontrolniPregled;
import com.example.institucija.domain.Pregled;

import java.util.Date;
import java.util.List;

public interface KontrolniPregledService {
    KontrolniPregled addKontrolniPregled(KontrolniPregled kontrolniPregled, Long idPregled);
    KontrolniPregled getKontrolniPregled(Long id);
    void deleteKontrolniPregled(Long idPregled, Long idKontrolniPregled);
    void updateKontrolniPregled(Long idPregled, Long idKontrolniPregled, Date datum);
    List<KontrolniPregled> getKontrolniPregledi();
}