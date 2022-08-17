package br.com.cwi.AumigoEstouAqui.factories;

import br.com.cwi.AumigoEstouAqui.domain.Postagem;

import java.time.LocalDate;

public class PostagemFactory {

    public static Postagem getAdicionar() {
        return Postagem.builder()
                .descricao("olhem o dog")
                .build();
    }
}
