package com.example.gestionprojet.services;

import com.example.gestionprojet.entities.Projet;
import com.example.gestionprojet.entities.Tache;

import java.util.List;

public interface ITacheService {

    List<Tache> getAllTachesSortedById();

    Tache addTacheToProject(Tache tache, int project_id);

    void deleteAllTasksOfProject(int project_id);
}
