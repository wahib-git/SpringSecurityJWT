package org.example.springsecurityjwt.models;

import jakarta.persistence.*;
import java.net.ProtocolFamily;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {
    }
    public Role(ERole name) {
    }

    public ProtocolFamily getName() {
        return null;
    }
}
