package com.tdd.project.Controller;

import com.tdd.project.Entity.Client;
import com.tdd.project.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @GetMapping("getAll")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/byId/{id}")
    public Client findByID(@PathVariable(name = "id") Long id){
        return clientService.findClientById(id);
    }

    @GetMapping("/byEmail/{email}")
    public Client findByEmail(@PathVariable(name = "email") String email){
        return clientService.findClientByEmail(email);
    }

    @GetMapping("/bySex/{sex}")
    public List<Client> findBySex(@PathVariable(name = "sex") String sex){
        return clientService.getClientsBySex(sex);
    }

    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestParam(name = "id") Long id){
        clientService.deleteClient(id);
    }

}
