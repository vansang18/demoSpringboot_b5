package com.example.demo_b5.Entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ID;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
    @Column(nullable = false)
    private Boolean isDeleted=false ;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(String ID, String email, String password, String firstName, String lastName, Date birthDay, Boolean isDeleted) {
        this.ID = ID;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.isDeleted = isDeleted;
    }
}
