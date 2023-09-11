package br.com.web.Exercicio2.entities.Pessoa;

public record DadosListagemPessoa(Long id, String nome, String email, String cpf, String dataNascimento) {

    public DadosListagemPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getCpf(), pessoa.getDataNascimento());
    }
}
