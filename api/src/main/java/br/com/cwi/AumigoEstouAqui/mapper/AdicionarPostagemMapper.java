package br.com.cwi.AumigoEstouAqui.mapper;

import br.com.cwi.AumigoEstouAqui.controller.request.AdicionarPostagemRequest;
import br.com.cwi.AumigoEstouAqui.domain.Postagem;

public class AdicionarPostagemMapper {
    public static Postagem toEntity(AdicionarPostagemRequest request) {
        return Postagem.builder()
                .lugar(request.getLugar())
                .fotoPostagem(request.getFotoPostagem())
                .descricao(request.getDescricao())
                .privado(request.getPrivado())
                .build();
    }
}
