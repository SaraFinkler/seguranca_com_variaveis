package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.controller.response.ComentarioPaginadoResponse;
import br.com.cwi.AumigoEstouAqui.domain.Postagem;
import br.com.cwi.AumigoEstouAqui.mapper.ComentarioPaginadoMapper;
import br.com.cwi.AumigoEstouAqui.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentariosPorIdService {

    @Autowired
    private PostagemRepository postagemRepository;

    public List<ComentarioPaginadoResponse> comentariosPorId(Long id) {
        Postagem postagem = postagemRepository.findById(id).get();
        return postagem.getComentarios().stream()
                .map(ComentarioPaginadoMapper::toResponse)
                .collect(Collectors.toList());
    }
}