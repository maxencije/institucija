package com.example.institucija.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
