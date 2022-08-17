package br.com.cwi.AumigoEstouAqui.mapper;

import br.com.cwi.AumigoEstouAqui.controller.response.PostagensResponse;
import br.com.cwi.AumigoEstouAqui.domain.Postagem;

public class EncontrarPostagemMapper {

    public static PostagensResponse toResponse(Postagem entity) {
        return PostagensResponse.builder()
                .fotoPostagem(entity.getFotoPostagem())
                .descricao(entity.getDescricao())
                .dataPostagem(entity.getDataPostagem())
                .curtidas(entity.getCurtidas())
                .lugar(entity.getLugar())
                .privado(entity.getPrivado())
                .id(entity.getId())
                .usuario(entity.getUsuario().getNome())
                .build();
    }
}
