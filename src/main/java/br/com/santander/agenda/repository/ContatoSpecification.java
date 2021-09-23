package br.com.santander.agenda.repository;


import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.model.Contato_;

import org.springframework.data.jpa.domain.Specification;

public class ContatoSpecification {
    public static Specification<Contato> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Contato_.NOME), nome);
    }

    public static Specification<Contato> sobrenome(String sobrenome) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Contato_.SOBRENOME),  sobrenome );
        };
    }
}
