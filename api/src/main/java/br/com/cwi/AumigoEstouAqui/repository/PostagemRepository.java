package br.com.cwi.AumigoEstouAqui.repository;

import br.com.cwi.AumigoEstouAqui.domain.Postagem;
import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    Page<Postagem> findAllByOrderByDataPostagemDesc(Pageable pageable);

    @Query("select p from Postagem p where p.usuario in (:usuario) and p.privado = true")
    List<Postagem> FindByUsuarioInAndIsPrivadoFalse(List<Usuario> usuario);
}