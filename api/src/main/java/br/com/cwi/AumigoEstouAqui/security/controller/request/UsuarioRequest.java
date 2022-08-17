package br.com.cwi.AumigoEstouAqui.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class UsuarioRequest {

    @NotBlank
    private String tipo;

    @NotNull
    private String nome;

    @NotNull @Email
    private String email;

    @NotBlank
    private String senha;

    @NotNull @NotEmpty
    private List<String> permissoes;

    private String apelido;

    private LocalDate data;

    private String imagem;

    private Integer numeroAnimais;

    private String endereco;

    private String atuacao;
}
