package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "owner")
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "direccion")
    private String address;
    @Column(name = "telefono")
    private String telephone;
    @Column(name = "email")
    private String email;

    public Owner() {
    }

    public Owner(Integer id, String nombres, String address, String telephone, String email) {
        super();
        this.id = id;
        this.nombres = nombres;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }
}
