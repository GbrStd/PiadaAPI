package com.example.piadaapi.repository;

import com.example.piadaapi.model.Cidade;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CidadeRepository extends MongoRepository<Cidade, String> {

    Optional<Cidade> findByNomeIgnoreCase(String nome);

}
