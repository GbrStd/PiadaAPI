package com.example.piadaapi.service;

import com.example.piadaapi.model.Avaliacao;
import com.example.piadaapi.model.Piada;
import com.example.piadaapi.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final PiadaService piadaService;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, PiadaService piadaService) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.piadaService = piadaService;
    }

    public Avaliacao insert(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> last10() throws Exception {
        final List<Avaliacao> avaliacaos = avaliacaoRepository.findLast10ByOrderByDataAvaliacaoDesc();
        if (avaliacaos.isEmpty()) throw new Exception("Não há avaliacaos cadastradas");
        return avaliacaos;
    }

    public void avaliar(String id, int nota) {
        final Piada piada = piadaService.findById(id);

        if (piada == null) throw new RuntimeException("Piada não encontrada");

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setPiada(piada);
        avaliacao.setNota(nota);
        avaliacao.setDataAvaliacao(LocalDateTime.now());

        insert(avaliacao);
    }
}
