package br.com.cwi.AumigoEstouAqui.security.repository;

import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    @Query(value = "select * from usuario where nome ilike %?1% or email ilike %?1%", nativeQuery = true)
    List<Usuario> findByEmailENome(String dado);
}
