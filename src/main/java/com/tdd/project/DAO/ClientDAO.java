package com.tdd.project.DAO;

import com.tdd.project.Entity.Client;

import java.util.List;

public interface ClientDAO {

    // “/clients/save” → Ajouter un client ou une liste de clients.
    Client addClient(Client client);

    // “/clients/” → Sélectionner l’ensemble des clients (utilisée la pagination).
    List<Client> getAllClients();

    // “/clients/{id}” → Chercher un client par identifiant.
    Client findClientById(Long idClient);

    // “/clients/{email}” → Chercher un client par email.
    Client findClientByEmail(String email);

    // “/clients/all/{sex}” → Chercher l’ensemble des clients par sex.
    List<Client> getClientsBySex(String sex);

    // “/clients/{id}” → Supprimer un client (désactiver)
    Client deleteClient(Long id);

    // “/clients/{id}” → Modifier un client.
    Client updateClient(Client client);




}
