package br.com.web.Exercicio2.entities.Pessoa.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;
    @Column
    private String senha;

    public Usuario(DadosCadastroUsuario dadosLogin){
        this.login = dadosLogin.login();
        this.senha = dadosLogin.senha();
    }


}




















