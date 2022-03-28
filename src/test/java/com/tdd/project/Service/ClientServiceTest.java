package com.tdd.project.Service;

import com.sun.source.tree.ModuleTree;
import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;
import com.tdd.project.Repository.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ClientServiceTest {

    @Mock
    ClientRepository clientRipository;

    @InjectMocks
    ClientService clientService;

    Client client;
    Client client2;
    Client client3;

    @BeforeEach
    void setUp() {
        client = new Client(1L,"mohssine.elattari@gmail.com","+21269845678","fullName",26, SexEnumeration.HOMME,true);
        client2 = new Client(2L, "mohsssine@gmail.com","+212612345678","elastamo",25,SexEnumeration.HOMME,true);
        client3 = new Client(3L, "sara@gmail.com","+212612367328","saralato",12,SexEnumeration.FAMME,true);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addClient() {

        Mockito.when(clientRipository.save(client))
                .thenReturn(client);

        Client client1=clientService.addClient(client);

        System.out.println(client);
        System.out.println(client1);

        assertEquals(client,client);


//
//        Mockito.when(clientService.addClient(client2))
//                .thenReturn(client2);
//
////        assertEquals(client1,clientService.addClient(client2));
//        System.out.println(client1);
//        System.out.println(client2);
        System.out.println("########################");
        System.out.println("########################");
        System.out.println("########################");
        System.out.println("************************");


        System.out.println("************************");

//        Client client4 = null;
//        assertNotNull(client1);
//        System.out.println(client1);

        System.out.println("************************");
        System.out.println("########################");
        System.out.println("########################");
        System.out.println("########################");

    }

    @Test
    void getAllClients() {

        List<Client> clients = new ArrayList<>();

        clients.add(client);
        clients.add(client2);
        clients.add(client3);

        Mockito.when(clientRipository.findAll()).thenReturn(clients);
        assertNotNull(clients);


        List<Client>clients1=clientService.getAllClients();

        clients1.forEach(c->{
            System.out.println(c);
        });

//
//        given(clientRipository.findAll()).willReturn(clients);
//
//        List<Client> clients2 = clientService.getAllClients();
//
//        clients2.forEach(c -> {
//            System.out.println(c);
//        });
//
//        assertEquals(clients2,clients);
//
//        //to verify
//        verify(clientRipository).findAll();

    }

    @Test
    void findClientById() {

        Mockito.lenient().when(clientRipository.findById(1L)).thenReturn(Optional.of(client));
        System.out.println(client);
        Client client1 = clientService.findClientById(1L);
        assertEquals(client,client);

//        Mockito.lenient().when(clientRipository.findById(7L)).thenReturn(Optional.of(new Client()));
//        Client client7 = clientService.findClientById(7L);
//        System.out.println(client7);
//        assertNotNull(client);

    }

    @Test
    void findClientByEmail() {
        Mockito.lenient().when(clientRipository.findClientByEmail("mohssine.elattari@gmail.com")).thenReturn(client);
        System.out.println(client);
        Client client1 = clientService.findClientByEmail("mohssine.elattari@gmail.com");
        System.out.println(client1);
        assertEquals(client1,client);
    }

    @Test
    void getClientsBySex() {
        List<Client> clients = new ArrayList<>();

        clients.add(client);
        clients.add(client2);
        clients.add(client3);
        Mockito.lenient().when(clientRipository.findClientBySex(SexEnumeration.HOMME)).thenReturn(clients);
        List<Client>clients1 = clientService.getClientsBySex(SexEnumeration.HOMME);

        clients1.forEach(c ->{
            System.out.println(c);
        } );

        assertEquals(clients,clients1);
    }

    @Test
    void deleteClient() {
        Mockito.lenient().when(clientRipository.findById(1L)).thenReturn(Optional.of(client));
        System.out.println(clientService.deleteClient(client.getId()));
        assertEquals(clientService.deleteClient(client.getId()),"Customer has been removed successfully!");
    }

    @Test
    void updateClient() {
        Client client1 = new Client(2L, "mohsssine@gmail.com","+212612345678","elastamo",25,SexEnumeration.HOMME,true);
        Mockito.lenient().when(clientRipository.findById(client.getId())).thenReturn(Optional.of(client));
        client1.setEmail("yap_map@gmail.com");
        client1.setNomComplete("yap map");
        System.out.println(client1);
        System.out.println(client);
        assertEquals(clientService.findClientById(1L),client);
    }

    @Test
    void compteActive() {
        List<Client> clients = new ArrayList<>();

        clients.add(client);
        clients.add(client2);
        clients.add(client3);
        Mockito.lenient().when(clientRipository.ClientActive()).thenReturn(clients);

        clients.forEach(c->{
            System.out.println(c);
        });
        System.out.println("***************************");
        List<Client> clientList=clientService.CompteActive();
        clientList.forEach(cc->{
            System.out.println(cc);

        });

        assertEquals(clientService.CompteActive(),clients);
    }
}