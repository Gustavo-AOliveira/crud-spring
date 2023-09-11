package br.com.web.Exercicio2.entities.Pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;
    private boolean ativo;
    public Pessoa(DadosCadastroPessoa dadosCadastroPessoa){
        this.nome = dadosCadastroPessoa.nome();
        this.email = dadosCadastroPessoa.email();
        this.cpf = dadosCadastroPessoa.cpf();
        this.dataNascimento = dadosCadastroPessoa.dataNascimento();
        this.ativo = true;
    }
    public void excluir(long id){
        this.ativo = false;
    }

    public void atualizar(DadosAtualizacaoPessoa dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
    }
}




























