package com.example.institucija.controller;

import com.example.institucija.domain.KontrolniPregled;
import com.example.institucija.domain.Pregled;
import com.example.institucija.service.KontrolniPregledService;
import com.example.institucija.service.PregledService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pregled")
public class PregledController {

    private PregledService pregledService;
    private KontrolniPregledService kontrolniPregledService;

    @GetMapping("/{id}")
    public ResponseEntity<Pregled> getPregled(@PathVariable Long id) {
        return ResponseEntity.ok(pregledService.getPregled(id));
    }

    @PostMapping
    public ResponseEntity<Pregled> savePregled(@RequestBody Pregled pregled) {
        return ResponseEntity.ok(pregledService.savePregled(pregled));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregled(@PathVariable Long id) {
        pregledService.deletePregled(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePregled(@PathVariable Long id, @RequestBody Date datum) {
        pregledService.updatePregled(id, datum);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pregled>> getPregledi() {
        return ResponseEntity.ok(pregledService.getPregledi());
    }

    @GetMapping("/{id}/kontrolni_pregledi")
    public ResponseEntity<List<KontrolniPregled>> getKontrolniPreglediFromPregled(@PathVariable Long id) {
        return ResponseEntity.ok(pregledService.getKontrolniPreglediByPregledId(id));
    }

    @GetMapping("/pacijent/{id}")
    public ResponseEntity<List<Pregled>> getPreglediByPacijent(@PathVariable Long id) {
        return ResponseEntity.ok(pregledService.getPreglediByPacijent(id));
    }
}