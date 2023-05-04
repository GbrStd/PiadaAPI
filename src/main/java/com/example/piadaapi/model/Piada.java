package com.example.piadaapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Piada {

    @Id
    private String id;

    private Tipo tipo;

    private String titulo;

    private String conteudo;

    private String descricao;

}
