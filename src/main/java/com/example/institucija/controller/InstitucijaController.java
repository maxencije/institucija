package com.example.institucija.controller;

import com.example.institucija.domain.Institucija;
import com.example.institucija.service.InstitucijaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/institucija")
public class InstitucijaController {

    private InstitucijaService institucijaService;

    @GetMapping("/{naziv}")
    public ResponseEntity<Institucija> getInstitucija(@PathVariable String naziv) {
        return ResponseEntity.ok().body(institucijaService.getInstitucija(naziv));
    }

    @PostMapping("/add")
    public ResponseEntity<Institucija> addInstitucija(@RequestBody Institucija institucija) {
        return ResponseEntity.ok().body(institucijaService.save(institucija));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Institucija>> getAll() {
        return ResponseEntity.ok().body(institucijaService.getInstitucije());
    }
}