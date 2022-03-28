package com.tdd.project.Repository;

import com.tdd.project.Entity.Client;
import com.tdd.project.Enum.SexEnumeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRipository extends JpaRepository<Client,Long> {

//    ******************************************

    Client findByEmail(String email);

    @Query(value = "select * from CLIENT where EMAIL = :email",  nativeQuery = true)
    Client findClientByEmail( @Param("email") String email);

    //******************************************
    @Query(value = "select * from CLIENT where SEX = :sex",  nativeQuery = true)
    List<Client> findClientBySex(@Param("sex") SexEnumeration sex);

    @Query("SELECT count(e) FROM Client e WHERE UPPER(e.sex) = upper(:sex) ")
    int numberOfClinetBySex(@Param("sex") SexEnumeration sex);

    //******************************************

    @Query("SELECT count(e) FROM Client e where e.age=:age")
    int numberOfClientByAge(@Param("age") int age);

    //******************************************

    @Query("SELECT e FROM Client e where e.isActive=true ")
    List<Client> ClientActive();

    //******************************************




}
