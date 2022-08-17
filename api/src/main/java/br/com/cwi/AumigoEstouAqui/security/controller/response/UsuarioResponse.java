package br.com.cwi.AumigoEstouAqui.security.controller.response;

import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String tipo;
    private List<String> permissoes;
    private String apelido;
    private LocalDate data;
    private String imagem;
    private Integer numeroAnimais;
    private String endereco;
    private String atuacao;
    private List<Usuario> amizades;
}
