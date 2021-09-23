package br.com.santander.agenda.model.dto;

import br.com.santander.agenda.model.Email;

public class EmailDto {
    private Integer id;
    private String email;

    public EmailDto(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public static EmailDto converte(Email retEmail) {
        return new EmailDto(retEmail.getId(), retEmail.getEmail());
    }

}


