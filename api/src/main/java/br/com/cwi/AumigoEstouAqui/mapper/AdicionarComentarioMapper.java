package br.com.cwi.AumigoEstouAqui.mapper;

import br.com.cwi.AumigoEstouAqui.controller.request.AdicionarComentarioRequest;
import br.com.cwi.AumigoEstouAqui.domain.Comentario;

public class AdicionarComentarioMapper {

    public static Comentario toEntity(AdicionarComentarioRequest request) {
        return Comentario.builder()
                .descricao(request.getDescricao())
                .build();
    }
}
