package com.example.piadaapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Avaliacao {

    @Id
    private String id;

    private Piada piada;

    private int nota; // 1 a 10

    private LocalDateTime dataAvaliacao;

}
