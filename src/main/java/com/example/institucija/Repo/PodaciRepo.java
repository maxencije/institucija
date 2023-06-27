package com.example.institucija.Repo;

import com.example.institucija.Domain.Podaci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodaciRepo extends JpaRepository<Podaci, Long> {
}
