package com.example.piadaapi.service;

import com.example.piadaapi.model.Autor;
import com.example.piadaapi.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor insert(Autor autor) {
        return autorRepository.insert(autor);
    }

    public Optional<Autor> findByNomeIgnoreCase(String nome) {
        return autorRepository.findByNomeIgnoreCase(nome);
    }

}
