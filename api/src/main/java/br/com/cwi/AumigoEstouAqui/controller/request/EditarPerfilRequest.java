package br.com.cwi.AumigoEstouAqui.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditarPerfilRequest {
    private String nome;
    private String apelido;
    private String imagem;
}
