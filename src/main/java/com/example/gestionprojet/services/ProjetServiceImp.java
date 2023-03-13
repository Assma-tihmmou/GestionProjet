package com.example.gestionprojet.services;

import com.example.gestionprojet.entities.Projet;
import com.example.gestionprojet.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetServiceImp implements IProjetService{
    @Autowired
    ProjetRepository projetRepository;


    @Override
    public List<Projet> getAllProjectSortedById() {
        return projetRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void saveProjet(Projet projet, int id) {
        projetRepository.saveProjet(projet.getTitre(),projet.getDescription(),id);
    }


}
