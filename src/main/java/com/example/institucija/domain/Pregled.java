package com.example.institucija.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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