package com.example.gestionprojet.services;

import com.example.gestionprojet.entities.Projet;
import com.example.gestionprojet.entities.Utilisateur;
import com.example.gestionprojet.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImp implements IUtilisateurService{
    @Autowired
    UtilisateurRepository utilisateurRepository;


    @Override
    public List<Utilisateur> getAllUtilisateursSortedById() {
        return utilisateurRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public void deleteUserById(int id) {
        utilisateurRepository.deleteById(id);
    }


}
