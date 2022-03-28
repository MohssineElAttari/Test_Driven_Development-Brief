package com.tdd.project.Service;

import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;

import java.util.List;


public interface IClientService {

    Client addClient(Client client);

    List<Client> getAllClients();

    Client findClientById(Long idClient);

    Client findClientByEmail(String email);

    List<Client> getClientsBySex(SexEnumeration sex);

    String deleteClient(Long id);

    Client updateClient(Client client);

    List<Client> CompteActive();
}
