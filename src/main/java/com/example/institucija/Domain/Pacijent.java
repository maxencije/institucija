package com.example.institucija.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
