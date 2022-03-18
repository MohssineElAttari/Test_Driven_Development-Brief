package com.tdd.project.Service;

import com.tdd.project.DAO.ClientDAO;
import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;
import com.tdd.project.Repository.ClientRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
//        return new Client(1L,"email","0615722515","ah howa ana",33, SexEnumeration.HOMME,true);
        return clientRipository.findByEmail(email);
    }

    @Override
    public List<Client> getClientsBySex(SexEnumeration sex) {
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

    public List<Client> CompteActive(){
        return clientRipository.ClientActive();
    }
}
