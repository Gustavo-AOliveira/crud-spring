package br.com.web.Exercicio2.repository;

import br.com.web.Exercicio2.entities.Pessoa.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Page<Pessoa> findAllByAtivoTrue(Pageable pageable);



}

