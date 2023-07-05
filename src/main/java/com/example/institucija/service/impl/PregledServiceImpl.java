package com.example.institucija.service.impl;

import com.example.institucija.domain.KontrolniPregled;
import com.example.institucija.domain.Pacijent;
import com.example.institucija.domain.Pregled;
import com.example.institucija.repo.KontrolniPregledRepo;
import com.example.institucija.repo.PregledRepo;
import com.example.institucija.service.KontrolniPregledService;
import com.example.institucija.service.PregledService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PregledServiceImpl implements PregledService, KontrolniPregledService {

    private final PregledRepo pregledRepo;
    private final KontrolniPregledRepo kontrolniPregledRepo;


    @Override
    public Pregled savePregled(Pregled pregled) {
        log.info("Saving new Pregled to the database");
        return pregledRepo.save(pregled);
    }

    @Override
    public Pregled getPregled(Long id) {
        log.info("Fetching Pregled {}", id);
        return pregledRepo.findById(id).orElse(null);
    }

    @Override
    public void deletePregled(Long id) {
        log.info("Deleting Pregled {}", id);
        pregledRepo.deleteById(id);
    }

    @Override
    public void updatePregled(Long id, Date datum) {
        log.info("Searching for Pregled with ID {}", id);
        Pregled _pregled = pregledRepo.findById(id).orElse(null);
        if(_pregled == null) {
            log.info("Pregled {} not found", id);
            return;
        }
        _pregled.setDatum(datum);
        log.info("Pregled found and updated {}", id);
        pregledRepo.save(_pregled);
    }

    @Override
    public List<Pregled> getPregledi() {
        log.info("Fetching all Pregledi");
        return pregledRepo.findAll();
    }

    @Override
    public List<Pregled> getPreglediByPacijent(Long idPacijent) {
        log.info("Fetching all Pregledi by Pacijent with ID {}", idPacijent);
        return pregledRepo.getPreglediByPacijent(idPacijent);
    }

    @Override
    public List<KontrolniPregled> getKontrolniPreglediByPregledId(Long id) {
        log.info("Fetching all KontrolniPregledi by Pregled");
        return pregledRepo.getKontrolniPreglediByPregledId(id);
    }

    @Override
    public KontrolniPregled addKontrolniPregled(KontrolniPregled kontrolniPregled, Long idPregled) {
        log.info("Saving new Kontrolni Pregled to Pregled {}", idPregled);
        Pregled _pregled = pregledRepo.findById(idPregled).orElse(null);
        if(_pregled == null) {
            log.info("Pregled {} not found", idPregled);
            return null;
        }
        _pregled.getKontrolniPregledi().add(kontrolniPregled);
        log.info("New Kontrolni Pregled saved to Pregled {}", idPregled);
        pregledRepo.save(_pregled);
        return kontrolniPregledRepo.save(kontrolniPregled);
    }

    @Override
    public KontrolniPregled getKontrolniPregled(Long id) {
        log.info("Fetching Kontrolni Pregled {}", id);
        return kontrolniPregledRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteKontrolniPregled(Long idPregled, Long idKontrolniPregled) {
        log.info("Deleting Kontrolni Pregled {}", idKontrolniPregled);
        kontrolniPregledRepo.deleteById(idKontrolniPregled);
        Optional<Pregled> pregled = pregledRepo.findById(idPregled);
        Optional<KontrolniPregled> kontrolniPregled = kontrolniPregledRepo.findById(idKontrolniPregled);
        if(pregled.isPresent()) {
            Pregled _pregled = pregled.get();
            if(kontrolniPregled.isEmpty()) {
                log.info("Kontrolni Pregled {} not found", idKontrolniPregled);
                return;
            }
            log.info("Kontrolni Pregled {} not found", idKontrolniPregled);
            _pregled.getKontrolniPregledi().remove(kontrolniPregled.get());
        }
        log.info("Pregled {} not found", idPregled);
    }

    @Override
    public void updateKontrolniPregled(Long idPregled, Long idKontrolniPregled, Date datum) {
        log.info("Searching for Pregled with ID {}", idPregled);
        Pregled _pregled = pregledRepo.findById(idPregled).orElse(null);
        if(_pregled == null) {
            log.info("Pregled {} not found", idPregled);
            return;
        }
        KontrolniPregled _kontrolniPregled = kontrolniPregledRepo.findById(idKontrolniPregled).orElse(null);
        if(_kontrolniPregled == null) {
            log.info("Kontrolni Pregled {} not found", idKontrolniPregled);
            return;
        }
        if(_pregled.getKontrolniPregledi().contains(_kontrolniPregled)) {
            log.info("Kontrolni Pregled {} found within Pregled {} and updated", idKontrolniPregled, idPregled);
            _pregled.getKontrolniPregledi().remove(_kontrolniPregled);
            _kontrolniPregled.setDatum(datum);
            _pregled.getKontrolniPregledi().add(_kontrolniPregled);
            pregledRepo.save(_pregled);
            kontrolniPregledRepo.save(_kontrolniPregled);
        }
    }

    @Override
    public List<KontrolniPregled> getKontrolniPregledi() {
        return kontrolniPregledRepo.findAll();
    }
}
