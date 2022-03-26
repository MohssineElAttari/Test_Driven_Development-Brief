package com.tdd.project.Service;

import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;
import com.tdd.project.Repository.ClientRipository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    ClientRipository clientRipository;

    @InjectMocks
    ClientService clientService;

    Client client;
    Client client2;
    Client client3;

    @BeforeEach
    void setUp() {
        client = new Client(1L,"mohssine.elattari@gmail.com","+212615722515","fullName",26, SexEnumeration.HOMME,true);
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

        Mockito.when(clientService.getAllClients()).thenReturn(clients);
        assertNotNull(clients);

        given(clientRipository.findAll()).willReturn(clients);

        List<Client> clients2 = clientService.getAllClients();

        clients2.forEach(c -> {
            System.out.println(c);
        });

        assertEquals(clients2,clients);

        //to verify
        verify(clientRipository).findAll();

    }

    @Test
    void findClientById() {

        Mockito.lenient().when(clientRipository.findById(1L)).thenReturn(Optional.of(client));
        System.out.println(client);
        Client client1 = clientService.findClientById(1L);
        assertEquals(client1,client);

//        Mockito.lenient().when(clientRipository.findById(7L)).thenReturn(Optional.of(new Client()));
//        Client client7 = clientService.findClientById(7L);
//        System.out.println(client7);
//        assertNotNull(client);

    }

    @Test
    void findClientByEmail() {
        Mockito.lenient().when(clientRipository.findClientByEmail("mohssine.elattari@gmail.com")).thenReturn(client);
        System.out.println(client);
        Client client1 = clientService.findClientByEmail("mohssine@gmail.com");
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

    }

    @Test
    void updateClient() {

    }

    @Test
    void compteActive() {

    }
}