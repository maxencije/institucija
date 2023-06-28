package com.example.institucija.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @ManyToOne
    @JoinColumn(name = "kontrolniPregled_id")
    private KontrolniPregled kontrolniPregled;
    @OneToOne
    private Podaci podatak;
}