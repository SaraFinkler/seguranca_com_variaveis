package br.com.cwi.AumigoEstouAqui.repository;

import br.com.cwi.AumigoEstouAqui.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findAllComentarioByPostagemId(Long id);
}
