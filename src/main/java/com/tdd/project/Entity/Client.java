package com.tdd.project.Entity;

import com.tdd.project.Enum.SexEnumeration;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENT")
@ToString
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @NotBlank(message="Please enter your email")
    @Email(message="Please respect the email format")
    @Column(name = "EMAIL", unique = true)
    private String email;

    @NonNull
    @NotBlank(message="Please enter your number phone")
    @Column(name = "NUMBER_PHONE" )
    @Pattern(regexp = "(\\+212|1)(\\d){9}")
    private String phone;

    @NonNull
    @Column(name = "NOM_COMPLETE")
    @NotBlank(message="Please enter your complete name")
    private String nomComplete;

    @NonNull
    @Column(name = "AGE")
    private int age;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name="SEX")
    private SexEnumeration sex;

    @NonNull
    @Column(name = "IS_ACTIVE")
    private boolean isActive;

}
