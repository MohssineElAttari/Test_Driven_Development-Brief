package com.tdd.project.Entity;

import com.tdd.project.Enum.SexEnumeration;
import jdk.jfr.DataAmount;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENT")
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @NotBlank(message="Please enter your email")
    private String email;

    @NonNull
    @NotBlank(message="Please enter your phone number")
    @Column(name = "number_phone")
    @Pattern(regexp = "^(?:(?:(?:\\+|00)212[\\s]?(?:[\\s]?\\(0\\)[\\s]?)?)|0){1}(?:5[\\s.-]?[2-3]|(6|7)[\\s.-]?[13-9]){1}[0-9]{1}(?:[\\s.-]?\\d{2}){3}$", message = "{validation.client.phone.pattern}")
    private String phone;


    @NonNull
    @NotBlank(message="Please enter your name")
    private String nomComplete;

    @NonNull
    @NotBlank(message="Please enter your age")
    private int age;

    @NonNull
    @NotBlank(message="Please enter your sex")
    private SexEnumeration sex;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive;
}
