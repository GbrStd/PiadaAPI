package com.example.piadaapi.service;

import com.example.piadaapi.model.Cidade;
import com.example.piadaapi.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Cidade insert(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public Optional<Cidade> findByNomeIgnoreCase(String nome) {
        return cidadeRepository.findByNomeIgnoreCase(nome);
    }

}
