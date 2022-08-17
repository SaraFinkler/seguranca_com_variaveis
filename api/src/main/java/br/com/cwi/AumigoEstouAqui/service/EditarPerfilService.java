package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.controller.request.EditarPerfilRequest;
import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import br.com.cwi.AumigoEstouAqui.security.repository.UsuarioRepository;
import br.com.cwi.AumigoEstouAqui.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class EditarPerfilService {
    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    UsuarioRepository usuarioRepository;

    public void editarPerfil (EditarPerfilRequest request) {
        Usuario usuario = usuarioAutenticadoService.get();
        if(nonNull(request.getNome())){
            usuario.setNome(request.getNome());
        }
        if(nonNull(request.getApelido())) {
            usuario.setApelido(request.getApelido());
        }
        if(nonNull(request.getImagem())) {
            usuario.setImagem(request.getImagem());
        }
        usuarioRepository.save(usuario);
    }
}
