package br.com.santander.agenda.repository;

import br.com.santander.agenda.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContatoRepository extends JpaRepository<Contato,  Integer>, JpaSpecificationExecutor<Contato> {
}
