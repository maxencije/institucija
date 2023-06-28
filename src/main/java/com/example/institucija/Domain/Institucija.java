package com.example.institucija.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Institucija {

    @Id
    @GeneratedValue
    @Column(name = "institucija_id")
    private Long id;
    private String ime;
    @OneToMany(mappedBy = "institucija", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pregled> pregledi;
    @OneToMany(mappedBy = "institucija", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<KontrolniPregled> kontrolniPregledi;
}
