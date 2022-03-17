package com.tdd.project.Repository;

import com.tdd.project.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRipository extends JpaRepository<Client,Long> {
    Client findByEmail(String email);
    List<Client> findBySex(String sex);

}
