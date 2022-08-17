package br.com.cwi.AumigoEstouAqui.security.service;

import br.com.cwi.AumigoEstouAqui.security.controller.request.EncontrarUsuarioRequest;
import br.com.cwi.AumigoEstouAqui.security.controller.response.UsuarioResponse;
import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import br.com.cwi.AumigoEstouAqui.security.mapper.BuscarUsuarioMapper;
import br.com.cwi.AumigoEstouAqui.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static br.com.cwi.AumigoEstouAqui.security.mapper.UsuarioMapper.toResponse;
import static java.util.stream.Collectors.toList;

@Service
public class BuscarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponse buscar() {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();
        return toResponse(usuarioAutenticado);
    }

    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        return toResponse(usuario);
    }

    public UsuarioResponse buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return toResponse(usuario);
    }

    public Usuario porId(Long id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Usuário não encontrado"));
    }

    public List<UsuarioResponse> buscarUsuario(EncontrarUsuarioRequest dado) {

        return usuarioRepository.findByEmailENome(dado.getDado())
                .stream()
                .map(BuscarUsuarioMapper::toResponse)
                .collect(toList());
    }
}
