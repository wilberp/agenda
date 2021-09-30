package br.com.santander.agenda.service;

import br.com.santander.agenda.model.Contato;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ContatoService {

    Contato buscaContatoPorId(Integer id);
    List<Contato> buscaContatos();
    Contato salvaContato(Contato contato);
    boolean verificaPorNomeESobrenome(String nome, String sobrenome);
    Contato salvaFotoContatoId(Integer id, String file);
    Contato alteraContato(Contato contato);
    void deletaContato (Integer id);

}
