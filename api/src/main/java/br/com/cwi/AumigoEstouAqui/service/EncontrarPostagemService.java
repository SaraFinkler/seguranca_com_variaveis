package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.controller.response.PostagensResponse;
import br.com.cwi.AumigoEstouAqui.domain.Postagem;
import br.com.cwi.AumigoEstouAqui.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.AumigoEstouAqui.mapper.EncontrarPostagemMapper.toResponse;


@Service
public class EncontrarPostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    public PostagensResponse buscarPorId(Long id) {
        Postagem postagem  = postagemRepository.findById(id).get();
        return toResponse(postagem);
    }
}
