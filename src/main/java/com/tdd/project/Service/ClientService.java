package com.tdd.project.Service;

import com.tdd.project.DAO.ClientDAO;
import com.tdd.project.Entity.Client;
import com.tdd.project.Repository.ClientRipository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientService implements ClientDAO {

    @Autowired
    private ClientRipository clientRipository;

    @Override
    public Client addClient(Client client) {
        return clientRipository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRipository.findAll();
    }

    @Override
    public Client findClientById(Long idClient) {
        return clientRipository.findById(idClient).get();
    }

    @Override
    public Client findClientByEmail(String email) {
        return clientRipository.findByEmail(email);
    }

    @Override
    public List<Client> getClientsBySex(String sex) {
        return clientRipository.findBySex(sex);
    }

    @Override
    public void deleteClient(Long id) {
        clientRipository.deleteById(id);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRipository.save(client);
    }
}
