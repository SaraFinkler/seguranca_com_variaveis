package br.com.cwi.AumigoEstouAqui.repository;

import br.com.cwi.AumigoEstouAqui.domain.CurtidasPostagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidasPostagemRepository extends JpaRepository<CurtidasPostagem, Long> {

    CurtidasPostagem findCurtidasPostagemByUsuarioIdAndPostagemId(Long usuarioId, Long postagemId);
}
