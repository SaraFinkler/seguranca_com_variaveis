package br.com.cwi.AumigoEstouAqui.service;

import br.com.cwi.AumigoEstouAqui.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemPrivadaService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public String gerarMensagem() {
        return "Rota privada: " + usuarioAutenticadoService.get().getTipo();
    }
}
