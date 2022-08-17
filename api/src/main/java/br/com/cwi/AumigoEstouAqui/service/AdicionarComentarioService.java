package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.controller.request.AdicionarComentarioRequest;
import br.com.cwi.AumigoEstouAqui.domain.Comentario;
import br.com.cwi.AumigoEstouAqui.domain.Postagem;
import br.com.cwi.AumigoEstouAqui.repository.ComentarioRepository;
import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import br.com.cwi.AumigoEstouAqui.security.repository.UsuarioRepository;
import br.com.cwi.AumigoEstouAqui.security.service.BuscarUsuarioService;
import br.com.cwi.AumigoEstouAqui.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import static br.com.cwi.AumigoEstouAqui.mapper.AdicionarComentarioMapper.toEntity;

@Service
public class AdicionarComentarioService {

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private TimeNowService timeNowService;

    public void adicionarComentario(Long idPostagem, AdicionarComentarioRequest request) {

        Postagem postagem = buscarPostagemService.porId(idPostagem);
        Usuario usuario = usuarioAutenticadoService.get();
        LocalDateTime agora = timeNowService.getDate();

        Comentario comentario = toEntity(request);
        comentario.setUsuario(usuario);
        comentario.setCurtidas(0);
        comentario.setDataComentario(agora);

        postagem.adicionarComentario(comentario);

        comentarioRepository.save(comentario);
    }
}
