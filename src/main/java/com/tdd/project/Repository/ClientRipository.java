package com.tdd.project.Repository;

import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRipository extends JpaRepository<Client,Long> {


    Client findByEmail(String email);

    List<Client> findBySex(SexEnumeration sex);


    @Query("SELECT count(e) FROM Client e WHERE UPPER(e.sex) = upper(:sex) ")
    int numberOfClinetBySex(@Param("sex") SexEnumeration sex);

    @Query("SELECT count(e) FROM Client e where  e.age=:age")
    int numberOfClientByAge(@Param("age") int age);

    @Query("SELECT e FROM Client e where e.isActive=true ")
    List<Client> ClientActive();

}
