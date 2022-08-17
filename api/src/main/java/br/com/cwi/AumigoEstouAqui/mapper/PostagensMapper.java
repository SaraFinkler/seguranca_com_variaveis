package br.com.cwi.AumigoEstouAqui.mapper;

import br.com.cwi.AumigoEstouAqui.controller.response.PostagensResponse;
import br.com.cwi.AumigoEstouAqui.domain.Postagem;

public class PostagensMapper {

    public static PostagensResponse toResponse(Postagem entity) {
        return PostagensResponse.builder()
                .id(entity.getId())
                .usuarioNome(entity.getUsuario().getNome())
                .usuarioFoto(entity.getUsuario().getImagem())
                .dataPostagem(entity.getDataPostagem())
                .lugar(entity.getLugar())
                .fotoPostagem(entity.getFotoPostagem())
                .curtidas(entity.getCurtidas())
                .descricao(entity.getDescricao())
                .privado(entity.getPrivado())
                .build();
    }
}
