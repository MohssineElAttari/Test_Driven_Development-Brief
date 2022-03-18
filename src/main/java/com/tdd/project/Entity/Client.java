package com.tdd.project.Entity;

import com.tdd.project.Enum.SexEnumeration;
import jdk.jfr.DataAmount;
import lombok.*;

import javax.persistence.*;

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
//    @NotBlank(message="Please enter your email")
    private String email;

    @NonNull
    @Column(name = "number_phone")
//    @Pattern(regexp = "^(?:(?:(?:\\+|00)212[\\s]?(?:[\\s]?\\(0\\)[\\s]?)?)|0){1}(?:5[\\s.-]?[2-3]|(6|7)[\\s.-]?[13-9]){1}[0-9]{1}(?:[\\s.-]?\\d{2}){3}$", message = "{validation.client.phone.pattern}")
    private String phone;

    @NonNull
    private String nomComplete;

    @NonNull
    private int age;

    @NonNull
    private SexEnumeration sex;

    @NonNull
    private boolean isActive;
}
