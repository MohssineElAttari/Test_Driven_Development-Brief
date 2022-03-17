package com.tdd.project.Repository;

import com.tdd.project.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRipository extends JpaRepository<Client,Long> {
}
