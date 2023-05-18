package com.example.piadaapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Autor {

    @Id
    private String id;

    private String nome;

    private String telefone;

    private String email;

    private Cidade cidade;

}
