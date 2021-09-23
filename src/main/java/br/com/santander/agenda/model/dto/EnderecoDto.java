package br.com.santander.agenda.model.dto;

import br.com.santander.agenda.model.Endereco;

public class EnderecoDto {

	private Integer id;
	private String rua;
	private String numero;
	private String cidade;
	private String tipo;

	public EnderecoDto(String rua, String numero, String cidade, String tipo) {
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.tipo = tipo;
	}


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

	public static EnderecoDto converte(Endereco endereco) {
		return new EnderecoDto(endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getTipo());
	}
}
