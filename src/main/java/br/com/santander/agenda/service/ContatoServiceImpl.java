package br.com.santander.agenda.service;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.model.dto.ContatoDto;
import br.com.santander.agenda.repository.ContatoRepository;
import br.com.santander.agenda.repository.ContatoSpecification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class ContatoServiceImpl implements ContatoService {

    ContatoRepository contatoRepository;

    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Contato buscaContatoPorId(Integer id){
        Contato ret = contatoRepository.getById(id);
        return ret;
    }

    @Override
    public List<Contato> buscaContatos(){
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
    @Override
    public Contato salvaFotoContatoId(Integer id, String file) {
        Contato retornoContato = contatoRepository.getById(id);
        retornoContato.setImagem(file);
        if (retornoContato!=null){
            return contatoRepository.save(retornoContato);
        }else{
            return null;
        }
    }

    @Override
    public Contato alteraContato(Contato contato) {
        Contato retornoContato = contatoRepository.getById(contato.getId());
        if (retornoContato != null) {
            return contatoRepository.save(contato);
        }
        return retornoContato;
    }

    @Override
    public void deletaContato(Integer id) {
        Contato retornoContato = contatoRepository.getById(id);
        if (retornoContato != null) {
            contatoRepository.deleteById(retornoContato.getId());
        }
    }
}
