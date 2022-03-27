package com.tdd.project.Repository;

import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;
import com.tdd.project.Service.ClientService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ClientRipositoryTest {

    @Mock
    private ClientRipository clientRipository;

    Client client1 = new Client(1L,"Mohssine@gmail.com","+212618123456","mohssine elattari",25, SexEnumeration.HOMME,true);
    Client client2 = new Client(2L,"younes@gmail.com","+212615722515","younes maska",25, SexEnumeration.HOMME,true);
    Client client3 = new Client(3L,"othman@gmail.com","+212612345678","othman kahtal",19, SexEnumeration.HOMME,true);

    List<Client> clientList =new ArrayList<>();

    @Test
    void findByEmail() {
//        Mockito.lenient().when(clientRipository.findByEmail("Mohssine@gmail.com")).thenReturn(client1);
        Mockito.doReturn(client1).when(clientRipository).findByEmail("Mohssine@gmail.com");

        assertEquals(clientRipository.findByEmail("Mohssine@gmail.com"),client1);
        assertNotNull(clientRipository.findByEmail("Mohssine@gmail.com"));
        assertNull(clientRipository.findByEmail("test@gmail.com"));


    }

    @Test
    void findClientByEmail() {
        Mockito.lenient().when(clientRipository.findClientByEmail("Mohssine@gmail.com")).thenReturn(client1);
        assertEquals(clientRipository.findClientByEmail("Mohssine@gmail.com"),client1);
        assertNotNull(clientRipository.findClientByEmail("Mohssine@gmail.com"));
        assertNull(clientRipository.findClientByEmail("test@gmail.com"));
    }

    @Test
    void findClientBySex() {
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        Mockito.doReturn(clientList).when(clientRipository).findClientBySex(SexEnumeration.HOMME);
//        assertFalse(clientRipository.findClientBySex(SexEnumeration.HOMME).isEmpty());
        Mockito.lenient().when(clientRipository.findClientBySex(SexEnumeration.HOMME)).thenReturn(clientList);
        clientList.forEach(c->{
            System.out.println(c.toString());
        });

    }

    @Test
    void numberOfClinetBySex() {
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        Mockito.lenient().when(clientRipository.numberOfClinetBySex(SexEnumeration.HOMME)).thenReturn(clientList.size());
        assertEquals(clientRipository.numberOfClinetBySex(SexEnumeration.HOMME),3);

    }

    @Test
    void numberOfClientByAge() {
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        List<Client>clients=clientList;

        Mockito.lenient().when(clientRipository.numberOfClientByAge(22));
        assertEquals(clientRipository.numberOfClientByAge(22),3);
    }

    @Test
    void clientActive() {
        Mockito.doReturn(clientList).when(clientRipository).ClientActive();
        assertNotNull(clientRipository.ClientActive());
        Mockito.verify(clientRipository,Mockito.times(1)).ClientActive();

    }
}