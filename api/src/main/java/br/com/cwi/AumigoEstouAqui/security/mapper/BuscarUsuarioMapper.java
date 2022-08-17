package br.com.cwi.AumigoEstouAqui.security.mapper;

import br.com.cwi.AumigoEstouAqui.security.controller.response.UsuarioResponse;
import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;

public class BuscarUsuarioMapper {

    public static UsuarioResponse toResponse(Usuario entity) {
        return UsuarioResponse.builder()
                .email(entity.getEmail())
                .nome(entity.getNome())
                .build();
    }
}
