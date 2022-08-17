package br.com.cwi.AumigoEstouAqui.domain;

import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Postagem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDateTime dataPostagem;
    private String lugar;
    private String fotoPostagem;
    private Integer curtidas;
    private String descricao;
    private Boolean privado;

    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios = new ArrayList<>();

    public void adicionarComentario(Comentario comentario) {
        this.getComentarios().add(comentario);
        comentario.setPostagem(this);
    }
}
