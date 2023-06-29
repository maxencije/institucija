package com.example.institucija.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pacijent {

    @Id
    @GeneratedValue
    @Column(name = "pacijent_id")
    private Long id;
    private String ime;
    private String prezime;
    private int starost;
    private String brKnjizice;
    @OneToMany
    @JoinColumn(name = "pregled_id")
    private List<Pregled> pregledi;
    @OneToMany
    @JoinColumn(name = "kontrolniPregled_id")
    private List<KontrolniPregled> kontrolniPregledi;
}
