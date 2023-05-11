package com.example.piadaapi.controller;

import com.example.piadaapi.model.Avaliacao;
import com.example.piadaapi.service.AvaliacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping("/last10")
    public ResponseEntity<List<Avaliacao>> last10() throws Exception {
        return ResponseEntity.ok(avaliacaoService.last10());
    }

    @PostMapping("/avaliar/{id}")
    public ResponseEntity<String> avaliar(@PathVariable String id, @RequestParam int nota) {
        if (nota < 0 || nota > 10)
            return ResponseEntity.badRequest().body("Nota deve ser entre 0 e 10");
        avaliacaoService.avaliar(id, nota);
        return ResponseEntity.ok("Avaliação realizada com sucesso!");
    }

}
