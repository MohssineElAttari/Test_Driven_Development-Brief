package com.tdd.project.Controller;

import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;
import com.tdd.project.Respone.ResponseHandler;
import com.tdd.project.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<Object> addClient(@Valid @RequestBody Client client){

        System.out.println(client.toString());
        try {
            Client result = clientService.addClient(client);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.NOT_FOUND,null);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllClients(){
        try {
            List<Client> result = clientService.getAllClients();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Object> findByID(@PathVariable(name = "id") Long id){
        Client result=clientService.findClientById(id);
        try {
            if (result==null){
                return ResponseHandler.generateResponse("unavailable data!",HttpStatus.OK,result);
            }
            return ResponseHandler.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @GetMapping("/byEmail/{email}")
    public ResponseEntity<Object> findByEmail(@PathVariable(name = "email") String email){
        Client result = clientService.findClientByEmail(email);
        try {
            return ResponseHandler.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @GetMapping("/bySex/{sex}")
    public ResponseEntity<Object> findBySex(@PathVariable(name = "sex") SexEnumeration sex){
        List<Client> result = clientService.getClientsBySex(sex);
        try {
            return ResponseHandler.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateClient(@RequestBody Client client){
        Client result= clientService.updateClient(client);
        try {
            return ResponseHandler.generateResponse("Successfully Update Client : "+client.getNomComplete(),HttpStatus.OK,result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteClient(@RequestParam(name = "id") Long id){
        try {
            clientService.deleteClient(id);
            return ResponseHandler.generateResponse("Successfully Delete Client"+"("+id+")",HttpStatus.OK,1);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
    @GetMapping("/activecompte")
    public List<Client> CompteActive(){
        return clientService.CompteActive();
    }
}
