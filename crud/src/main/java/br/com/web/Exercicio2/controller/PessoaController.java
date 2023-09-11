package br.com.web.Exercicio2.controller;

import br.com.web.Exercicio2.entities.Pessoa.DadosAtualizacaoPessoa;
import br.com.web.Exercicio2.entities.Pessoa.DadosCadastroPessoa;
import br.com.web.Exercicio2.entities.Pessoa.DadosListagemPessoa;
import br.com.web.Exercicio2.entities.Pessoa.Pessoa;
import br.com.web.Exercicio2.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("pessoas")
public class PessoaController {
    private PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DadosCadastroPessoa dados){
        repository.save(new Pessoa(dados));
    }
    @GetMapping("/findAll")
    public List<Pessoa> findAll(){
        return repository.findAll();
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemPessoa>> listAtivos(@PageableDefault(sort = {"nome"}, direction = Sort.Direction.ASC)Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemPessoa::new);
            return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemPessoa> findById(@PathVariable Long id){
        var pessoa = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosListagemPessoa(pessoa));

    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAtualizacaoPessoa dados){
        Pessoa pessoa = repository.getReferenceById(dados.id());
            pessoa.atualizar(dados);
                return ResponseEntity.ok(new DadosListagemPessoa(pessoa));

    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        var pessoa = repository.getReferenceById(id);
            pessoa.excluir(id);
                return ResponseEntity.noContent().build();
    }
}



























