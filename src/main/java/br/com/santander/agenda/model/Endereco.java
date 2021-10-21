package br.com.santander.agenda.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rua;
	private String numero;
	private String cidade;
	private String tipo;
	@JsonIgnore
	@ManyToOne
	private Contato contato;

	public Endereco(String rua, String numero, String cidade, String tipo) {
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.tipo = tipo;
	}
	
	protected Endereco() {}

	public Integer getId() {
		return id;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTipo() {return tipo;	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Endereco{" +
				"id=" + id +
				", rua='" + rua + '\'' +
				", numero='" + numero + '\'' +
				", cidade='" + cidade + '\'' +
				", tipo='" + tipo + '\'' +
				", contato=" + contato +
				'}';
	}
}
