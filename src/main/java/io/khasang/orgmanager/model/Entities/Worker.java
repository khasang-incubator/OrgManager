package io.khasang.orgmanager.model.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "contrAgentId")
    private ContrAgent contrAgent;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String middleName;

    @Column
    private String title;

    @Column
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContrAgent getContrAgent() {
        return contrAgent;
    }

    public void setContrAgent(ContrAgent contrAgent) {
        this.contrAgent = contrAgent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
