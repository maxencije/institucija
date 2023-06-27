package com.example.institucija.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institucija {

    @Id
    @GeneratedValue
    @Column(name = "institucija_id")
    private Long id;
    private String ime;
    @OneToMany
    @JoinColumn(name = "pregled_id")
    private List<Pregled> pregledi;
    @OneToMany
    @JoinColumn(name = "kontrolniPregled_id")
    private List<KontrolniPregled> kontrolniPregledi;
}
