package br.com.cwi.AumigoEstouAqui.security.controller;

import br.com.cwi.AumigoEstouAqui.controller.request.EditarPerfilRequest;
import br.com.cwi.AumigoEstouAqui.security.controller.request.EncontrarUsuarioRequest;
import br.com.cwi.AumigoEstouAqui.security.controller.request.UsuarioRequest;
import br.com.cwi.AumigoEstouAqui.security.controller.response.UsuarioResponse;
import br.com.cwi.AumigoEstouAqui.security.service.AdicionarAmigoService;
import br.com.cwi.AumigoEstouAqui.security.service.BuscarUsuarioService;
import br.com.cwi.AumigoEstouAqui.security.service.IncluirUsuarioService;
import br.com.cwi.AumigoEstouAqui.service.BuscarAmigosService;
import br.com.cwi.AumigoEstouAqui.service.EditarPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private AdicionarAmigoService adicionarAmigoService;

    @Autowired
    private EditarPerfilService editarPerfilService;

    @Autowired
    private BuscarAmigosService buscarAmigosService;

    @GetMapping("/me")
    public UsuarioResponse buscar() {
        return buscarUsuarioService.buscar();
    }

    @GetMapping("/{id}")
    public UsuarioResponse encontrarUsuarioPorId(@PathVariable Long id) {
        return buscarUsuarioService.buscarPorId(id);
    }

    @GetMapping("/me/{email}")
    public UsuarioResponse encontrarUsuarioPorEmail(@PathVariable String email) {
        return buscarUsuarioService.buscarPorEmail(email);
    }

    @GetMapping
    private List<UsuarioResponse> encontrarUsuario(@Valid @RequestBody EncontrarUsuarioRequest request) {
        return buscarUsuarioService.buscarUsuario(request);
    }

    @GetMapping("/amizades")
    public List<UsuarioResponse> listaDeAmigos() {
        return buscarAmigosService.listaDeAmigos();
    }

    @PostMapping
    public UsuarioResponse incluir(@Valid @RequestBody UsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editarPerfil(@Valid @RequestBody EditarPerfilRequest request) {
        editarPerfilService.editarPerfil(request);
    }

    @PutMapping("/{id}/amigo")
    private void adicionarAmigo(@Valid @PathVariable Long id) {
        adicionarAmigoService.adicionar(id);
    }

}
