package br.com.santander.agenda.service;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.model.dto.ContatoDto;
import br.com.santander.agenda.repository.ContatoRepository;
import br.com.santander.agenda.repository.ContatoSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class ContatoServiceImpl implements ContatoService {

    ContatoRepository contatoRepository;

    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Contato getContato(Integer id){
        return contatoRepository.getById(id);
    }

    @Override
    public List<Contato> getAll(){
        return contatoRepository.findAll();
    }

    @Override
    public boolean verificaPorNomeESobrenome(String nome, String sobrenome) {
        List<Contato> retorno = contatoRepository.findAll(where(ContatoSpecification.nome(nome))
                .and(ContatoSpecification.sobrenome(sobrenome)));

        return retorno.size() == 0 ? false : true;
    }

    @Override
    public Contato salvaContato(Contato contato) {

        if (contato!=null){
            boolean retorno = verificaPorNomeESobrenome(contato.getNome(), contato.getSobrenome());
            return retorno == false ? contatoRepository.save(contato) : null;
        }else{
            return null;
        }
    }
}
