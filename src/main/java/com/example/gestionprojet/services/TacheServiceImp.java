package com.example.gestionprojet.services;

import com.example.gestionprojet.entities.Projet;
import com.example.gestionprojet.entities.Tache;
import com.example.gestionprojet.repositories.ProjetRepository;
import com.example.gestionprojet.repositories.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheServiceImp implements ITacheService{
    @Autowired
    TacheRepository tacheRepository;
    @Autowired
    ProjetRepository projetRepository;


    @Override
    public List<Tache> getAllTachesSortedById() {
        return tacheRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Tache addTacheToProject(Tache tache, int project_id) {
        Projet projet = projetRepository.findById(project_id).get();
        Tache tache1 = new Tache(tache.getId(),tache.getTitre(), tache.getDescription(),projet);
      return tacheRepository.save(tache1);
    }

    @Override
    public void deleteAllTasksOfProject(int project_id) {
        List<Tache> taches = tacheRepository.findAll();

        for (Tache tache: taches){
            if (tache.getProjet().getId()==project_id){
                tacheRepository.delete(tache);
            }
        }
    }


}
