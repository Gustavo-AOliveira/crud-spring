package br.com.web.Exercicio2.entities.Pessoa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long id,
        String nome,
        @Email
        String email
) {
}
