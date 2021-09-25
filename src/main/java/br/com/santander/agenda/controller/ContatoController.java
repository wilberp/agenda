package br.com.santander.agenda.controller;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.model.dto.ContatoDto;
import br.com.santander.agenda.service.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private static String diretorioUpload = "C:\\teste_upload\\";


    ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }


    @GetMapping
    public ResponseEntity<List<Contato>> todosContatos(){
        return ResponseEntity.ok(contatoService.buscaContatos());
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


    @PutMapping("/{id}/upload")
    public ResponseEntity<?> upload(@PathVariable Integer id, @RequestBody MultipartFile file) {
        System.out.println(String.format(" Id %s, file %s", id, file.getOriginalFilename()));

        Contato retornoContato = contatoService.buscaContatoPorId(id);

        if (retornoContato == null) {
            return ResponseEntity.noContent().build();
        } else {
            File uploadFile = new File(file.getOriginalFilename());
            try {
                uploadFile.createNewFile();
                String caminhoNomeArquivo = diretorioUpload + uploadFile;
                FileOutputStream fso = new FileOutputStream(caminhoNomeArquivo);
                fso.write(file.getBytes());
                fso.close();

                retornoContato = contatoService.salvaFotoContatoId(id, caminhoNomeArquivo);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResponseEntity.ok(retornoContato);
        }
    }
}
