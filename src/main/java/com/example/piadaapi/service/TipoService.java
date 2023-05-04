package com.example.piadaapi.service;

import com.example.piadaapi.model.Tipo;
import com.example.piadaapi.repository.TipoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoService {

    private final TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public Tipo insert(Tipo tipo) {
        return tipoRepository.insert(tipo);
    }

    public boolean exists(String id) {
        return tipoRepository.existsById(id);
    }

    public Optional<Tipo> findByDescricao(String descricao) {
        return tipoRepository.findByDescricaoIgnoreCase(descricao);
    }

}
