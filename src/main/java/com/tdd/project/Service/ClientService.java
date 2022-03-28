package com.tdd.project.Service;

import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;
import com.tdd.project.Repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client findClientById(Long idClient) {
        Client existClient = clientRepository.findById(idClient).orElse(null);
        if(existClient!=null){
        return clientRepository.findById(idClient).get();
        }
        return existClient;
    }

    @Override
    public Client findClientByEmail(String email) {
//        return new Client(1L,"email","0615722515","ah howa ana",33, SexEnumeration.HOMME,true);
        Client existClient = clientRepository.findClientByEmail(email);
        if(existClient!=null){
            return clientRepository.findClientByEmail(email);
        }
        return existClient;
    }

    @Override
    public List<Client> getClientsBySex(SexEnumeration sex) {
        return clientRepository.findClientBySex(sex);
    }

    @Override
    public String deleteClient(Long id) {
        try {
            if(clientRepository.findById(id).isPresent()){
                clientRepository.deleteById(id);
                return "Customer has been removed successfully!";
            }else{
                return "The customer has not been removed!";
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return "null";
        }
    }

    @Override
    public Client updateClient(Client client) {
        Client existClient = clientRepository.findById(client.getId()).orElse(null);
        if(existClient!=null){

            return clientRepository.save(client);
        }
        return client;
    }

    public List<Client> CompteActive(){
        if (clientRepository.ClientActive()==null){
            return null;
        }
        return  clientRepository.ClientActive();

    }
}
