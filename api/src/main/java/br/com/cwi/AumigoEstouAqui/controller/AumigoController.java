package br.com.cwi.AumigoEstouAqui.controller;

import br.com.cwi.AumigoEstouAqui.service.MensagemPrivadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aumigo")
public class AumigoController {

    @Autowired
    private MensagemPrivadaService mensagemPrivadaService;

    @GetMapping
    public String privado() {
        return mensagemPrivadaService.gerarMensagem();
    }

    @Secured("ROLE_ONG")
    @GetMapping("/ong")
    public String ong() {
        return "Rota privada, exclusiva para usuários ONG";
    }

    @GetMapping("/publico")
    public String adotantes() {
        return "Rota pública";
    }

}
