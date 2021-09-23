package br.com.santander.agenda.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @ManyToOne
    private Contato contato;

    protected Email() {
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

}


