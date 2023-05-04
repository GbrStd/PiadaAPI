package com.example.piadaapi.repository;

import com.example.piadaapi.model.Piada;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PiadaRepository extends MongoRepository<Piada, String> {
}
