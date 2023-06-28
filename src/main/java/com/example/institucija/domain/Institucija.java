package com.example.institucija.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Institucija {

    @Id
    @GeneratedValue
    @Column(name = "institucija_id")
    private Long id;
    private String naziv;
    @OneToMany(mappedBy = "institucija", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pregled> pregledi;
    @OneToMany(mappedBy = "institucija", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<KontrolniPregled> kontrolniPregledi;
}
