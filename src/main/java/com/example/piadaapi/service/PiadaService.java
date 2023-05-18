package com.example.piadaapi.service;

import com.example.piadaapi.dto.PiadaDto;
import com.example.piadaapi.model.Autor;
import com.example.piadaapi.model.Cidade;
import com.example.piadaapi.model.Piada;
import com.example.piadaapi.model.Tipo;
import com.example.piadaapi.repository.PiadaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PiadaService {

    private final PiadaRepository piadaRepository;
    private final AutorService autorService;
    private final CidadeService cidadeService;
    private final TipoService tipoService;

    public PiadaService(PiadaRepository piadaRepository, AutorService autorService, CidadeService cidadeService, TipoService tipoService) {
        this.piadaRepository = piadaRepository;
        this.autorService = autorService;
        this.cidadeService = cidadeService;
        this.tipoService = tipoService;
    }

    public void insert(PiadaDto... piadaDto) {

        final List<Piada> piadas = new ArrayList<>();

        for (PiadaDto dto : piadaDto) {
            final Piada piada = new Piada();

            autorService.findByNomeIgnoreCase(dto.getAutorDto().getNome()).ifPresent(piada::setAutor);

            if (piada.getAutor() == null) {
                final Autor autor = new Autor();

                autor.setNome(dto.getAutorDto().getNome());
                autor.setTelefone(dto.getAutorDto().getTelefone());
                autor.setEmail(dto.getAutorDto().getEmail());

                cidadeService.findByNomeIgnoreCase(dto.getAutorDto().getCidade()).ifPresent(autor::setCidade);

                if (autor.getCidade() == null) {
                    Cidade c = new Cidade();
                    c.setNome(dto.getAutorDto().getCidade());
                    autor.setCidade(cidadeService.insert(c));
                }

                piada.setAutor(autorService.insert(autor));
            }

            piada.setTitulo(dto.getNome());
            piada.setConteudo(dto.getConteudo());
            piada.setDescricao(dto.getDescricao());
            piada.setDataCriacao(LocalDateTime.now());

            final String descTipo = dto.getTipo();

            final Optional<Tipo> optionalTipo = tipoService.findByDescricao(descTipo);

            final Tipo tipo;
            if (optionalTipo.isEmpty()) {
                final Tipo t = new Tipo();
                t.setDescricao(descTipo);
                tipo = tipoService.insert(t);
            } else {
                tipo = optionalTipo.get();
            }

            piada.setTipo(tipo);
            piadas.add(piada);
        }

        piadaRepository.saveAll(piadas);
    }

    public Piada update(Piada piada) {
        return piadaRepository.save(piada);
    }

    public void delete(String id) {
        piadaRepository.deleteById(id);
    }

    public Piada findById(String id) {
        return piadaRepository.findById(id).orElse(null);
    }

    public Iterable<Piada> findAll() {
        return piadaRepository.findAll();
    }

    public Piada random() throws Exception {
        final List<Piada> piadas = piadaRepository.findAll();
        if (piadas.isEmpty()) throw new Exception("Não há piadas cadastradas");
        final int random = (int) (Math.random() * piadas.size());
        return piadas.get(random);
    }

}
