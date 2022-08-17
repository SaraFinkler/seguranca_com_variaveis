package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.controller.request.AdicionarPostagemRequest;
import br.com.cwi.AumigoEstouAqui.domain.Postagem;
import br.com.cwi.AumigoEstouAqui.repository.PostagemRepository;
import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import br.com.cwi.AumigoEstouAqui.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static br.com.cwi.AumigoEstouAqui.mapper.AdicionarPostagemMapper.toEntity;
@Service
public class AdicionarPostagemService {
    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private TimeNowService timeNowService;

    @Autowired
    private PostagemRepository postagemRepository;

    public void adicionarPostagem(AdicionarPostagemRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();
        LocalDateTime agora = timeNowService.getDate();
        Postagem postagem = toEntity(request);
        postagem.setDataPostagem(agora);
        postagem.setCurtidas(0);

        usuario.adicionarPostagem(postagem);

        postagemRepository.save(postagem);

    }
}
