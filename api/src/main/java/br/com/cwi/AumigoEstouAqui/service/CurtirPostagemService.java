package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.domain.CurtidasPostagem;
import br.com.cwi.AumigoEstouAqui.domain.Postagem;
import br.com.cwi.AumigoEstouAqui.repository.CurtidasPostagemRepository;
import br.com.cwi.AumigoEstouAqui.repository.PostagemRepository;
import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;
import br.com.cwi.AumigoEstouAqui.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtirPostagemService {
    @Autowired
    BuscarPostagemService buscarPostagemService;

    @Autowired
    PostagemRepository postagemRepository;

    @Autowired
    CurtidasPostagemRepository curtidasPostagemRepository;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    public void curtir(Long id) {
        Postagem postagem = buscarPostagemService.porId(id);
        Usuario usuario = usuarioAutenticadoService.get();
        CurtidasPostagem curtidasPostagem = curtidasPostagemRepository.findCurtidasPostagemByUsuarioIdAndPostagemId(usuario.getId(), postagem.getId());

        if (curtidasPostagem != null) {
            if (postagem.getCurtidas() > 0) {
                postagem.setCurtidas(postagem.getCurtidas() - 1);
            }
            curtidasPostagemRepository.delete(curtidasPostagem);
        } else {
            postagem.setCurtidas(postagem.getCurtidas() + 1);
            CurtidasPostagem curtidasPost = new CurtidasPostagem();
            curtidasPost.setPostagem(postagem);
            curtidasPost.setUsuario(usuario);
            curtidasPostagemRepository.save(curtidasPost);
        }
        postagemRepository.save(postagem);

    }

    public Boolean curtidasUsuarioPostagem(Long id) {
        Postagem postagem = buscarPostagemService.porId(id);
        Usuario usuario = usuarioAutenticadoService.get();
        CurtidasPostagem curtidasPostagem = curtidasPostagemRepository.findCurtidasPostagemByUsuarioIdAndPostagemId(usuario.getId(), postagem.getId());
        return curtidasPostagem != null;
    }
}
