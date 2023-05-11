package com.example.piadaapi.repository;

import com.example.piadaapi.model.Avaliacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String> {

    List<Avaliacao> findLast10ByOrderByDataAvaliacaoDesc();

}
