package com.tdd.project.Entity;

import com.tdd.project.Enum.SexEnumeration;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message="Please enter your email")
    @Email(message="Please respect the email format")
    private String email;

    @NonNull
    @NotBlank(message="Please enter your number phone")
    @Column(name = "number_phone")
    @Pattern(regexp = "(\\+212|1)(\\d){9}")
    private String phone;

    @NonNull
    @NotBlank(message="Please enter your complete name")
    private String nomComplete;

    @NonNull
    private int age;

    @NonNull
    private SexEnumeration sex;

    @NonNull
    private boolean isActive;
}
