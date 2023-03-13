package com.example.gestionprojet.repositories;

import com.example.gestionprojet.entities.Projet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Integer> {
    @Modifying
    @Transactional
    void saveProjet(@Param("titre") String titre,
                      @Param("description") String description,
                    @Param("utilisateur_id") int utilisateur_id);

}
