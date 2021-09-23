package br.com.santander.agenda.service;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.model.dto.ContatoDto;

import java.util.List;

public interface ContatoService {

    Contato getContato(Integer id);
    List<Contato> getAll();
    Contato salvaContato(Contato contato);
    boolean verificaPorNomeESobrenome(String nome, String sobrenome);
}
