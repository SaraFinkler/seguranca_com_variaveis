package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.security.controller.response.UsuarioResponse;
import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import br.com.cwi.AumigoEstouAqui.security.mapper.UsuarioMapper;
import br.com.cwi.AumigoEstouAqui.security.repository.UsuarioRepository;
import br.com.cwi.AumigoEstouAqui.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarAmigosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public List<UsuarioResponse> listaDeAmigos() {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        List<Usuario> usuarios = usuarioAutenticado.getAmizades();

        return usuarios.stream().map(UsuarioMapper::toResponse).collect(Collectors.toList());
    }

}
