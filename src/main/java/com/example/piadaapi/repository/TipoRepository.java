package com.example.piadaapi.repository;

import com.example.piadaapi.model.Tipo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TipoRepository extends MongoRepository<Tipo, String> {

    Optional<Tipo> findByDescricaoIgnoreCase(String descricao);

}
