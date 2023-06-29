package com.example.institucija.service;

import com.example.institucija.domain.Institucija;

import java.util.List;
import java.util.Optional;

public interface InstitucijaService {
    Institucija save(Institucija institucija);
    Institucija getInstitucija(String naziv);
    List<Institucija> getInstitucije();
}
