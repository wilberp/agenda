package br.com.santander.agenda.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String residencial;
    private String celular;
    private String recado;
    @JsonIgnore
    @ManyToOne
    private Contato contato;

    public Telefone(String residencial, String celular, String recado) {
        this.residencial = residencial;
        this.celular = celular;
        this.recado = recado;
    }

    protected Telefone() {
    }

    public String getResidencial() {
        return residencial;
    }

    public String getCelular() {
        return celular;
    }

    public String getRecado() {
        return recado;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", residencial='" + residencial + '\'' +
                ", celular='" + celular + '\'' +
                ", recado='" + recado + '\'' +
                ", contato=" + contato +
                '}';
    }
}
