package com.tdd.project.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;
import com.tdd.project.Service.ClientService;
import com.tdd.project.util.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @MockBean
    ClientService clientService;

    @Autowired
    private MockMvc mockMvc;

    Client client,client2,client3;
    List<Client> clients;

    @BeforeEach
    void setUp(){
        client=new Client(1L,"email1@gmail.com","+212123456789","mohssine",23, SexEnumeration.HOMME,true);
        client2=new Client(2L,"email2@gmail.com","+212987654321","test",22, SexEnumeration.FAMME,true);
        client3=new Client(3L,"email3@gmail.com","+212543216789","yap",21, SexEnumeration.HOMME,true);
        clients =new ArrayList<>();
        clients.add(client);
        clients.add(client2);
        clients.add(client3);
    }
    @Test
    void addClient() throws Exception {
        Mockito.doReturn(client).when(clientService).addClient(client);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/client/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(client)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllClients() throws Exception {

        Mockito.doReturn(clients).when(clientService).getAllClients();
        // BDDMockito.given(clientService.getAllClients()).willReturn(clients);
        // List<Client>clients1=clientService.getAllClients();
        clients.forEach(c->{
            System.out.println(c);
        });
        mockMvc.perform(MockMvcRequestBuilders.get("/api/client/getAll")).andExpect(MockMvcResultMatchers.status().isOk()).
                andDo(MockMvcResultHandlers.print());
    }

    @Test
    void findByID() throws Exception {
        Mockito.doReturn(client).when(clientService).findClientById(client.getId());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/client//byId/"+client.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void findByEmail() {
    }

    @Test
    void findBySex() {
    }

    @Test
    void updateClient() throws Exception {
        Mockito.doReturn(client).when(clientService).updateClient(client);

        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.put("/api/client/update")
                        .content(mapper.writeValueAsString(client))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteClient() throws Exception {
//        Mockito.doReturn("Customer has been removed successfully!").when(clientService).deleteClient(client.getId());
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/client/delete/"+client.getId())
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void compteActive() {
    }
}