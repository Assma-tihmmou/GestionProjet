package com.example.gestionprojet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.NamedQuery;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQuery(name = "Projet.saveProjet",
        query =" insert into Projet (titre, description,utilisateur_id) VALUES (:titre, :description, :utilisateur_id)")

public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @JsonIgnore
    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<Tache> taches;
}
