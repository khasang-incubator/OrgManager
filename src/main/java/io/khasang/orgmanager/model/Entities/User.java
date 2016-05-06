package io.khasang.orgmanager.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column
    private String password;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Role role;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "managerId")
    private User manager;

    //подчиненные
    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    public Set<User> suborditates= new HashSet<>();

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Set<User> getSuborditates() {
        return suborditates;
    }

    public void setSuborditates(Set<User> suborditates) {
        this.suborditates = suborditates;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
