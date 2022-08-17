package br.com.cwi.AumigoEstouAqui.controller;

import br.com.cwi.AumigoEstouAqui.controller.request.AdicionarComentarioRequest;
import br.com.cwi.AumigoEstouAqui.controller.response.ComentarioPaginadoResponse;
import br.com.cwi.AumigoEstouAqui.service.AdicionarComentarioService;
import br.com.cwi.AumigoEstouAqui.service.ComentarioPaginadoService;
import br.com.cwi.AumigoEstouAqui.service.ComentariosPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioPaginadoService comentarioPaginadoService;

    @Autowired
    private AdicionarComentarioService adicionarComentarioService;

    @Autowired
    ComentariosPorIdService comentariosPorIdService;

    @GetMapping
    public Page<ComentarioPaginadoResponse> comentariosPaginado(Pageable pageable) {
        return comentarioPaginadoService.comentariosPaginado(pageable);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarComentario(@PathVariable Long id, @Valid @RequestBody AdicionarComentarioRequest request) {
        adicionarComentarioService.adicionarComentario(id, request);
    }

    @GetMapping("/{id}")
    public List<ComentarioPaginadoResponse> encontrarComentariosDoPost(@PathVariable Long id) {
        return comentariosPorIdService.comentariosPorId(id);
    }

}
