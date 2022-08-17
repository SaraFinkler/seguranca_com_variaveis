package br.com.cwi.AumigoEstouAqui.controller;

import br.com.cwi.AumigoEstouAqui.controller.request.AdicionarPostagemRequest;
import br.com.cwi.AumigoEstouAqui.controller.response.PostagensResponse;
import br.com.cwi.AumigoEstouAqui.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/postagem")
public class PostagemController {
    @Autowired
    private AdicionarPostagemService adicionarPostagemService;

    @Autowired
    private CurtirPostagemService curtirPostagemService;

    @Autowired
    private PostagensService postagensService;

    @Autowired
    private EncontrarPostagemService encontrarPostagemService;

    @Autowired
    private PostagensPrivadasService postagensPrivadasService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public PostagensResponse encontrarPostagemPorId(@PathVariable Long postagemId) {
       return encontrarPostagemService.buscarPorId(postagemId);
    }

    @GetMapping
    public Page<PostagensResponse> postagensPaginado(Pageable pageable) {
        return postagensService.postagensPaginado(pageable);
    }

    @GetMapping("/curtidas/{postagemId}")
    public Boolean curtidasPostagem(@PathVariable Long postagemId) {
        return curtirPostagemService.curtidasUsuarioPostagem(postagemId);
    }

    @GetMapping("/privadas")
    public List<PostagensResponse> listarPostagensPrivadas() {
        return postagensPrivadasService.postagensPrivadas();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarPostagem(@Valid @RequestBody AdicionarPostagemRequest request) {
        adicionarPostagemService.adicionarPostagem(request);
    }

    @PutMapping("/{postagemId}/curtir")
    @ResponseStatus(HttpStatus.CREATED)
    public void curtirPostagem(@PathVariable Long postagemId) {
        curtirPostagemService.curtir(postagemId);
    }
}
