package br.com.web.Exercicio2.repository;

import br.com.web.Exercicio2.entities.Pessoa.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
