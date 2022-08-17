package br.com.cwi.AumigoEstouAqui.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AdicionarAmizadeRequest {

    @NotNull
    private Long usuarioId;
}
