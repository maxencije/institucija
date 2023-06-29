package com.example.institucija.service.impl;

import com.example.institucija.domain.Pacijent;
import com.example.institucija.repo.PacijentRepo;
import com.example.institucija.service.PacijentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PacijentServiceImpl implements PacijentService {

    PacijentRepo pacijentRepo;

    @Override
    public Pacijent savePacijent(Pacijent pacijent) {
        log.info("Saving new Pacijent {} {} to the database", pacijent.getIme(), pacijent.getPrezime());
        return pacijentRepo.save(pacijent);
    }

    @Override
    public Pacijent getPacijent(String brojKnjizice) {
        log.info("Fetching Pacijent");
        return pacijentRepo.findByBrojKnjizice(brojKnjizice);
    }

    @Override
    public List<Pacijent> getPacijenti() {
        return pacijentRepo.findAll();
    }
}
