package br.com.cwi.AumigoEstouAqui.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComentarioPaginadoResponse {
    private Long id;
    private String usuarioNome;
    private String usuarioFoto;
    private LocalDateTime dataComentario;
    private Integer curtidas;
    private String descricao;
    private Long postagemId;
}
