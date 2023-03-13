package com.example.gestionprojet.repositories;

import com.example.gestionprojet.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheRepository extends JpaRepository<Tache,Integer> {
}
