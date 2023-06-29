package com.example.institucija.service.impl;

import com.example.institucija.domain.KontrolniPregled;
import com.example.institucija.domain.Pacijent;
import com.example.institucija.domain.Pregled;
import com.example.institucija.repo.PregledRepo;
import com.example.institucija.service.PregledService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PregledServiceImpl implements PregledService {

    private final PregledRepo pregledRepo;

    @Override
    public Pregled savePregled(Pregled pregled) {
        log.info("Saving new Pregled to the database");
        return pregledRepo.save(pregled);
    }

    @Override
    public Pregled getPregled(String id) {
        log.info("Fetching Pregled {}", id);
        return pregledRepo.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public void deletePregled(String id) {
        log.info("Deleting Pregled {}", id);
        pregledRepo.deleteById(Long.parseLong(id));
    }

    @Override
    public Pregled updatePregled(Long id, Date datum) {
        log.info("Searching for Pregled with ID {}", id);
        Pregled _pregled = pregledRepo.findById(id).orElse(null);
        if(_pregled == null) {
            log.info("Pregled {} not found", id);
            return null;
        }
        _pregled.setDatum(datum);
        log.info("Pregled found and updated {}", id);
        return pregledRepo.save(_pregled);
    }

    @Override
    public List<Pregled> getPregledi() {
        log.info("Fetching all Pregledi");
        return pregledRepo.findAll();
    }

    @Override
    public List<Pregled> getPreglediByPacijent(Pacijent pacijent) {
        log.info("Fetching all Pregledi by Pacijent {}", pacijent);
        return pregledRepo.getPreglediByPacijent(pacijent);
    }

    @Override
    public List<KontrolniPregled> getKontrolniPreglediByPregled() {
        log.info("Fetching all KontrolniPregledi by Pregled");
        return pregledRepo.getKontrolniPreglediByPregled();
    }
}
