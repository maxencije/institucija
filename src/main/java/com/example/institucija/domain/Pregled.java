package com.example.institucija.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pregled {

    @Id
    @GeneratedValue
    @Column(name = "pregled_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pacijent_id")
    private Pacijent pacijent;
    @ManyToOne
    @JoinColumn(name = "institucija_id")
    private Institucija institucija;
    private Date datum;
    @OneToMany
    @JoinColumn(name = "kontrolniPregled_id")
    private List<KontrolniPregled> kontrolniPregled;
    @OneToOne
    private Podaci podatak;
}