package br.com.cwi.AumigoEstouAqui.domain;

import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private LocalDateTime dataComentario;
    private Integer curtidas;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;
}
