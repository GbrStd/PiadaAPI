package com.example.piadaapi.dto;

import lombok.Data;

@Data
public class PiadaDto {

    private String tipo;

    private String nome;

    private String conteudo;

    private String descricao;

    private AutorDto autorDto;

}
