package com.tdd.project.DAO;

import com.tdd.project.Enum.SexEnumeration;

import java.util.List;

public interface DAO<T> {

    // “/objets/save” → Ajouter un objet ou une liste de objet.
    T addClient(T t);

    // “/objets/” → Sélectionner l’ensemble des objets (utilisée la pagination).
    List<T> getAll();

    // “/objets/{id}” → Chercher un objet par identifiant.
    T findById(Long id);

    // “/objets/{email}” → Chercher un objet par email.
    T findByEmail(String email);

    // “/objets/all/{sex}” → Chercher l’ensemble des objets par sex.
    List<T> getBySex(SexEnumeration sex);

    // “/objets/{id}” → Supprimer un objet (désactiver)
    void deleteobjet(Long id);

    // “/objests/{id}” → Modifier un objet.
    T update(T t);




}
