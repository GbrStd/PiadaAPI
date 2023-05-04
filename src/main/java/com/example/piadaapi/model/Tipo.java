package com.example.piadaapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Tipo {

    @Id
    private String id;

    private String descricao;

}
