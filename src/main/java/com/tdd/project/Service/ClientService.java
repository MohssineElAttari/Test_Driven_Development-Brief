package com.tdd.project.Service;

import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;
import com.tdd.project.Repository.ClientRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

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
        Client existClient = clientRipository.findById(idClient).orElse(null);
        if(existClient!=null){
        return clientRipository.findById(idClient).get();
        }
        return existClient;
    }

    @Override
    public Client findClientByEmail(String email) {
//        return new Client(1L,"email","0615722515","ah howa ana",33, SexEnumeration.HOMME,true);
        Client existClient = clientRipository.findClientByEmail(email);
        if(existClient!=null){
            return clientRipository.findClientByEmail(email);
        }
        return existClient;
    }

    @Override
    public List<Client> getClientsBySex(SexEnumeration sex) {
        return clientRipository.findClientBySex(sex);
    }

    @Override
    public void deleteClient(Long id) {
        clientRipository.deleteById(id);
    }

    @Override
    public Client updateClient(Client client) {
        Client existClient = clientRipository.findById(client.getId()).orElse(null);
        if(existClient!=null){

            return clientRipository.save(client);
        }
        return client;
    }

    public List<Client> CompteActive(){
        if (clientRipository.ClientActive()==null){
            return null;
        }
        return  clientRipository.ClientActive();

    }
}
