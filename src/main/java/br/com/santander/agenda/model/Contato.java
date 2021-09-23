package br.com.santander.agenda.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String apelido;

	@OneToMany (mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Telefone>  telefones = new ArrayList<>();
	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Email> emails = new ArrayList<>();


	public Contato(String nome, String sobrenome, LocalDate dataNascimento, String apelido, List<Telefone>  telefones, List<Endereco> enderecos, List<Email> emails ) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
		this.telefones = telefones;
		this.enderecos = enderecos;
		this.emails = emails;
	}

	protected Contato() {
	}

	public Integer getId() {return id;	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getApelido() {
		return apelido;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		enderecos.forEach(e -> adicionaEndereco(e));
	}

	public void adicionaEndereco(Endereco endereco) {
		endereco.setContato(this);
		this.enderecos.add(endereco);
	}

	public void setTelefones(Collection<Telefone> telefones) {
		telefones.forEach(e -> adicionaTelefone(e));
	}

	public void adicionaTelefone(Telefone telefone) {
		telefone.setContato(this);
		this.telefones.add(telefone);
	}

	public void setEmails(Collection<Email> emails) {
		emails.forEach(e -> adicionaEmail(e));
	}

	public void adicionaEmail(Email emails) {
		emails.setContato(this);
		this.emails.add(emails);
	}
}
