package br.com.santander.agenda.model.dto;

import br.com.santander.agenda.model.Telefone;

public class TelefoneDto {

    private Integer id;
    private String residencial;
    private String celular;
    private String recado;

    public TelefoneDto(String residencial, String celular, String recado) {
        this.residencial = residencial;
        this.celular = celular;
        this.recado = recado;
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

    public static TelefoneDto converte(Telefone telefone) {
        return new TelefoneDto(telefone.getResidencial(), telefone.getCelular(), telefone.getRecado());
    }

}
