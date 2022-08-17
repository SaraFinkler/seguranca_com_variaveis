package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.controller.response.ComentarioPaginadoResponse;
import br.com.cwi.AumigoEstouAqui.domain.Comentario;
import br.com.cwi.AumigoEstouAqui.mapper.ComentarioPaginadoMapper;
import br.com.cwi.AumigoEstouAqui.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComentarioPaginadoService {
    @Autowired
    private ComentarioRepository comentarioRepository;


    public Page<ComentarioPaginadoResponse> comentariosPaginado(Pageable pageable) {

        Page<Comentario> comentarios = comentarioRepository.findAll(pageable);

        Page<ComentarioPaginadoResponse> response = comentarios.map(comentario -> ComentarioPaginadoMapper.toResponse(comentario));

        return response;
    }
}
