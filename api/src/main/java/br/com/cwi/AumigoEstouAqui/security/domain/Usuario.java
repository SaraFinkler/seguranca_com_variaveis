package br.com.cwi.AumigoEstouAqui.security.domain;

import br.com.cwi.AumigoEstouAqui.domain.Postagem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String tipo;
    private String nome;
    private String email;
    private String senha;
    private boolean ativo;
    private String apelido;
    private LocalDate data;
    private String imagem;
    private Integer numeroAnimais;
    private String endereco;
    private String atuacao;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }

    @OneToMany(mappedBy = "usuario")
    private List<Postagem> postagens = new ArrayList<>();

    public void adicionarPostagem(Postagem postagem) {
        this.getPostagens().add(postagem);
        postagem.setUsuario(this);
    }

    @ManyToMany
    @JoinTable(name = "amizade",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "outro_usuario_id"))
    private List<Usuario> amizades = new ArrayList<>();


    public void adicionarAmigos(Usuario amigo) {
        this.getAmizades().add(amigo);
    }
}
