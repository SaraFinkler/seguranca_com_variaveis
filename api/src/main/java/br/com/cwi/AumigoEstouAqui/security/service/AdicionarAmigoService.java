package br.com.cwi.AumigoEstouAqui.security.service;

import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import br.com.cwi.AumigoEstouAqui.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionarAmigoService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;


    public void adicionar(Long id) {

        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        Usuario amigo = buscarUsuarioService.porId(id);

        Optional<Usuario> usuario = usuarioAutenticado.getAmizades().stream().filter(pessoa -> pessoa.getId().equals(id)).findFirst();
        if (!usuario.isPresent()) {
            usuarioAutenticado.adicionarAmigos(amigo);
        } else {
            usuarioAutenticado.getAmizades().remove(amigo);
        }
        usuarioRepository.save(usuarioAutenticado);
    }
}
