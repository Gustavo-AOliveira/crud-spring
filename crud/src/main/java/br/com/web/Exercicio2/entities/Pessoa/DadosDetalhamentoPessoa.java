package br.com.web.Exercicio2.entities.Pessoa;

public record DadosDetalhamentoPessoa( String nome,
         String email,
         String cpf,
         String dataNascimento,
         boolean ativo
) {
    public DadosDetalhamentoPessoa (Pessoa pessoa){
        this(pessoa.getNome(), pessoa.getEmail(), pessoa.getCpf(), pessoa.getDataNascimento(), pessoa.isAtivo());
    }
}
