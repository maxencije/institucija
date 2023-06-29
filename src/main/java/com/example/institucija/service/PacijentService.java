package com.example.institucija.service;

import com.example.institucija.domain.Pacijent;

import java.util.List;

public interface PacijentService {
    Pacijent savePacijent(Pacijent pacijent);
    Pacijent getPacijent(String brojKnjizice);
    List<Pacijent> getPacijenti();
}
