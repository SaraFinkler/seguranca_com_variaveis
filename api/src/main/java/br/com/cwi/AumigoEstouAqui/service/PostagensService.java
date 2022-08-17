package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.controller.response.PostagensResponse;
import br.com.cwi.AumigoEstouAqui.domain.Postagem;
import br.com.cwi.AumigoEstouAqui.mapper.PostagensMapper;
import br.com.cwi.AumigoEstouAqui.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostagensService {

    @Autowired
    private PostagemRepository postagemRepository;


    public Page<PostagensResponse> postagensPaginado(Pageable pageable) {

        Page<Postagem> postagens = postagemRepository.findAllByOrderByDataPostagemDesc(pageable);

        Page<PostagensResponse> response = postagens.map(livro -> PostagensMapper.toResponse(livro));

        return response;
    }
}