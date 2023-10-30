package br.com.web.Exercicio2.controller;

import br.com.web.Exercicio2.entities.Pessoa.Usuario.DadosCadastroUsuario;
import br.com.web.Exercicio2.entities.Pessoa.Usuario.Usuario;
import br.com.web.Exercicio2.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "*", maxAge = 33600)
@RestController
@RequestMapping("/login")
public class UsuarioController {

    private UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity createUsuario(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(dadosCadastroUsuario);
        repository.save(usuario);
        var uri = uriBuilder.path("/login/{id}").buildAndExpand(usuario.getLogin()).toUri();
            return ResponseEntity.created(uri).build();
    }
}













