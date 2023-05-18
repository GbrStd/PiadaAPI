package com.example.piadaapi.repository;

import com.example.piadaapi.model.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AutorRepository extends MongoRepository<Autor, String> {

    Optional<Autor> findByNomeIgnoreCase(String nome);

}
