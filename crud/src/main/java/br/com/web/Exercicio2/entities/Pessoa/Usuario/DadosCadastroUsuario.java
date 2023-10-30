package br.com.web.Exercicio2.entities.Pessoa.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroUsuario(
        @NotBlank(message = "O campo login não pode estar em branco")
        String login,

        @NotBlank(message = "O campo senha não pode estar em branco")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres" )
        String senha
) {

}
