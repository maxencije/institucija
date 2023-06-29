package com.example.institucija.service.impl;

import com.example.institucija.domain.Institucija;
import com.example.institucija.repo.InstitucijaRepo;
import com.example.institucija.service.InstitucijaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InstitucijaServiceImpl implements InstitucijaService {

    private final InstitucijaRepo institucijaRepo;

    @Override
    public Institucija save(Institucija institucija) {
        log.info("Saving new Institucija {} to the database", institucija.getNaziv());
        return institucijaRepo.save(institucija);
    }

    @Override
    public Institucija getInstitucija(String naziv) {
        log.info("Fetching Institucija {}", naziv);
        return institucijaRepo.findByNaziv(naziv).orElse(null);
    }

    @Override
    public List<Institucija> getInstitucije() {
        return institucijaRepo.findAll();
    }
}