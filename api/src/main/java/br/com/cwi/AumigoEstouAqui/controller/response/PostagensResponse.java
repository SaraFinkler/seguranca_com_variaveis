package br.com.cwi.AumigoEstouAqui.controller.response;

import lombok.*;

import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostagensResponse {
    private Long id;
    private String usuarioNome;
    private String usuarioFoto;
    private LocalDateTime dataPostagem;
    private String lugar;
    private String fotoPostagem;
    private Integer curtidas;
    private String descricao;
    private Boolean privado;
    private String usuario;
}
