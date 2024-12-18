package com.natanbsdev.picpaysimplificado.domain.user;

import com.natanbsdev.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

//    saldo desse usuário
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

//    public User(UserDTO data) {
//    }

    public User(UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.email = data.email();
        this.balance = data.balance();
        this.document = data.document();
        this.password = data.password();
        this.userType = data.userType();

    }
}
