package br.com.cwi.AumigoEstouAqui.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdicionarPostagemRequest {
    private String lugar;
    private String fotoPostagem;
    private String descricao;
    private Boolean privado;
}
