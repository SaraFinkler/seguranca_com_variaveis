package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.domain.Postagem;
import br.com.cwi.AumigoEstouAqui.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class BuscarPostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    public Postagem porId(Long id) {

        return postagemRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Postagem não encontrada"));
    }
}
