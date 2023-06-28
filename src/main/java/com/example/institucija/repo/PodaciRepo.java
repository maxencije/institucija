package com.example.institucija.repo;

import com.example.institucija.domain.Podaci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodaciRepo extends JpaRepository<Podaci, Long> {
}
