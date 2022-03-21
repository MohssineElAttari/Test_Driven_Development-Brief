package com.tdd.project.Entity;

import com.tdd.project.Enum.SexEnumeration;
import lombok.*;

import javax.persistence.*;
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
    private String email;

    @NonNull
    @NotBlank(message="Please enter your number phone")
    @Column(name = "number_phone")
    @Pattern(regexp = "^(?:(?:(?:\\+|00)212[\\s]?(?:[\\s]?\\(0\\)[\\s]?)?)|0){1}(?:5[\\s.-]?[2-3]|(6|7)[\\s.-]?[13-9]){1}[0-9]{1}(?:[\\s.-]?\\d{2}){3}$", message = "{validation.client.phone.pattern}")
    private String phone;

    @NonNull
    @NotBlank(message="Please enter your complete name")
    private String nomComplete;

    @NonNull
//    @NotBlank(message="Please enter your age")
    private int age;

    @NonNull
//    @NotBlank(message="Please enter your sex")
    private SexEnumeration sex;

    @NonNull
    private boolean isActive;
}
