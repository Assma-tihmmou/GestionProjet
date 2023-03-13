package com.example.gestionprojet.services;

import com.example.gestionprojet.entities.Projet;
import com.example.gestionprojet.entities.Utilisateur;

import java.util.List;

public interface IUtilisateurService {

    List<Utilisateur> getAllUtilisateursSortedById();

    void deleteUserById(int id);

}
