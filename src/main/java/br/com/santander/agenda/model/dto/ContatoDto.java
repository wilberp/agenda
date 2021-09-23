package br.com.santander.agenda.model.dto;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.model.Email;
import br.com.santander.agenda.model.Endereco;
import br.com.santander.agenda.model.Telefone;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContatoDto {

	private Integer id;
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String apelido;
	private List<TelefoneDto>  telefones = new ArrayList<>();
	private List<EnderecoDto> enderecos = new ArrayList<>();
	private List<EmailDto> emails = new ArrayList<>();


	public ContatoDto(Integer id, String nome, String sobrenome, LocalDate dataNascimento, String apelido, List<TelefoneDto> telefones, List<EnderecoDto> enderecos, List<EmailDto> emails) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
		this.telefones = telefones;
		this.enderecos = enderecos;
		this.emails = emails;
	}

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


	public List<TelefoneDto> getTelefones() {
		return telefones;
	}

	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}

	public List<EmailDto> getEmails() {
		return emails;
	}

	public static ContatoDto converte(Contato contato) {
		return new ContatoDto(contato.getId(),
				contato.getNome(),
				contato.getSobrenome(),
				contato.getDataNascimento(),
				contato.getApelido(),
				contato.getTelefones().stream()
						.map(TelefoneDto::converte)
						.collect(Collectors.toList()),
				contato.getEnderecos().stream()
						.map(EnderecoDto::converte)
						.collect(Collectors.toList()),
				contato.getEmails().stream()
						.map(EmailDto::converte)
						.collect(Collectors.toList()));
	}

//	public static ContatoDto converte(Contato contato) {
//		return new ContatoDto(contato.getId(), contato.getNome(), contato.getSobrenome(), contato.getApelido(),
//				contato.getTelefones().stream()
//						.map(TelefoneDto::converte)
//						.collect(Collectors.toList()),
//				contato.getEnderecos().stream()
//				.map(EnderecoDto::converte)
//				.collect(Collectors.toList()),
//				contato.getEmails().stream()
//				.map(EmailDto::converte)
//				.collect(Collectors.toList()));
//	}

}
