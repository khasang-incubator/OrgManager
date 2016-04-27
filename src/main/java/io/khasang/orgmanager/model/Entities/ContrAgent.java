package io.khasang.orgmanager.model.Entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Table(name = "ContrAgents")
public class ContrAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Type(type="text")
    private String name;

    @Column
    @Type(type="text")
    private String address;

    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
