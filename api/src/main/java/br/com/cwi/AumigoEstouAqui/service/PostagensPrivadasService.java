package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.controller.response.PostagensResponse;
import br.com.cwi.AumigoEstouAqui.domain.Postagem;
import br.com.cwi.AumigoEstouAqui.mapper.PostagensMapper;
import br.com.cwi.AumigoEstouAqui.repository.PostagemRepository;
import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import br.com.cwi.AumigoEstouAqui.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostagensPrivadasService {

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    PostagemRepository postagemRepository;

    public List<PostagensResponse> postagensPrivadas() {

        List<Postagem> postagens = new ArrayList<>();
        Usuario usuarioLogado = usuarioAutenticadoService.get();
        List<Postagem>  postagensPrivadas = postagemRepository.FindByUsuarioInAndIsPrivadoFalse(usuarioLogado.getAmizades());
        return postagensPrivadas.stream().map(PostagensMapper::toResponse).collect(Collectors.toList());
    }
}
