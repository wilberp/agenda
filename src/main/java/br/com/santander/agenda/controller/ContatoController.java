package br.com.santander.agenda.controller;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.model.dto.ContatoDto;
import br.com.santander.agenda.service.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<Contato>> todosContatos(){
        return ResponseEntity.ok(contatoService.getAll());
    }

    @PostMapping
    public ResponseEntity<ContatoDto> salvaContato(@RequestBody Contato contato)  {
        Contato retContato = contatoService.salvaContato(contato);

        if (retContato != null){
            ContatoDto retorno = ContatoDto.converte(retContato);
            URI uri = UriComponentsBuilder.fromPath("contato/{id}").buildAndExpand(contato.getId()).toUri();
            return ResponseEntity.created(uri).body(retorno);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
