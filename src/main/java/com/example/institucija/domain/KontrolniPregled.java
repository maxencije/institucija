package com.example.institucija.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class KontrolniPregled {

    @Id
    @GeneratedValue
    @Column(name = "kontrolniPregled_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pacijent_id")
    private Pacijent pacijent;
    @ManyToOne
    @JoinColumn(name = "institucija_id")
    private Institucija institucija;
    private Date datum;
    @OneToOne
    private Podaci podatak;
}
