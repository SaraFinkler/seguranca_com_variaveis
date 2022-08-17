package br.com.cwi.AumigoEstouAqui.security.mapper;

import br.com.cwi.AumigoEstouAqui.security.controller.request.UsuarioRequest;
import br.com.cwi.AumigoEstouAqui.security.controller.response.UsuarioResponse;
import br.com.cwi.AumigoEstouAqui.security.domain.Permissao;
import br.com.cwi.AumigoEstouAqui.security.domain.Usuario;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNome(request.getNome());
        entity.setTipo(request.getTipo());
        entity.setEmail(request.getEmail());
        entity.setApelido(request.getApelido());
        entity.setData(request.getData());
        entity.setImagem(request.getImagem());
        entity.setNumeroAnimais(request.getNumeroAnimais());
        entity.setEndereco(request.getEndereco());
        entity.setAtuacao(entity.getAtuacao());
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        return UsuarioResponse.builder()
                .id(entity.getId())
                .tipo(entity.getTipo())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .apelido(entity.getApelido())
                .data(entity.getData())
                .imagem(entity.getImagem())
                .numeroAnimais(entity.getNumeroAnimais())
                .endereco(entity.getEndereco())
                .atuacao(entity.getAtuacao())
                .permissoes(buildPermissoesResponse(entity.getPermissoes()))
                .build();
    }

    private static List<String> buildPermissoesResponse(List<Permissao> permissoes) {
        return permissoes.stream()
                .map(Permissao::getTipo)
                .collect(toList());
    }
}
