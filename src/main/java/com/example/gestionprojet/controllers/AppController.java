package com.example.gestionprojet.controllers;

import com.example.gestionprojet.entities.Projet;
import com.example.gestionprojet.entities.Tache;
import com.example.gestionprojet.entities.Utilisateur;
import com.example.gestionprojet.repositories.UtilisateurRepository;
import com.example.gestionprojet.services.ProjetServiceImp;
import com.example.gestionprojet.services.TacheServiceImp;
import com.example.gestionprojet.services.UtilisateurServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    UtilisateurServiceImp utilisateurServiceImp;
    @Autowired
    ProjetServiceImp projetServiceImp;
    @Autowired
    TacheServiceImp tacheServiceImp;

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getAllUsersSortedById(){
       return  utilisateurServiceImp.getAllUtilisateursSortedById();
    }

    @GetMapping("/projets")
    public List<Projet> getAllProjectsSortedById(){
        return  projetServiceImp.getAllProjectSortedById();
    }


    @GetMapping("/taches")
    public List<Tache> getAllTasksSortedById(){
        return tacheServiceImp.getAllTachesSortedById();
    }


    @PostMapping("/taches/add/{id}")
    public Tache addTacheToProject(@PathVariable int id,
                                   @RequestBody Tache tache){
        return tacheServiceImp.addTacheToProject(tache,id);
    }

    @DeleteMapping("/taches/delete/{id}")
    public void deleteTasksOfProject(@PathVariable int id){
        tacheServiceImp.deleteAllTasksOfProject(id);
    }

    @DeleteMapping("/utilisateur/delete/{id}")
    public void deleteUserById(@PathVariable int id){
        utilisateurServiceImp.deleteUserById(id);
    }

    @PostMapping("/projets/add/{id}")
    public void addProjet(@RequestBody Projet projet,@PathVariable int id){
        projetServiceImp.saveProjet(projet,id);
    }



}
