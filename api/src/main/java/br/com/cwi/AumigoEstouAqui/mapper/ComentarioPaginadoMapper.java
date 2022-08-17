package br.com.cwi.AumigoEstouAqui.mapper;

import br.com.cwi.AumigoEstouAqui.controller.response.ComentarioPaginadoResponse;
import br.com.cwi.AumigoEstouAqui.domain.Comentario;

public class ComentarioPaginadoMapper {
    public static ComentarioPaginadoResponse toResponse(Comentario entity) {
        return ComentarioPaginadoResponse.builder()
                .id(entity.getId())
                .usuarioNome(entity.getUsuario().getNome())
                .usuarioFoto(entity.getUsuario().getImagem())
                .dataComentario(entity.getDataComentario())
                .curtidas(entity.getCurtidas())
                .descricao(entity.getDescricao())
                .postagemId(entity.getPostagem().getId())
                .build();
    }
}
