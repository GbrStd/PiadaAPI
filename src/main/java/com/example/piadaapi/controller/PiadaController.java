package com.example.piadaapi.controller;

import com.example.piadaapi.dto.PiadaDto;
import com.example.piadaapi.model.Piada;
import com.example.piadaapi.service.PiadaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/piadas")
public class PiadaController {

    private final PiadaService piadaService;

    public PiadaController(PiadaService piadaService) {
        this.piadaService = piadaService;
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody PiadaDto... piadaDto) {
        piadaService.insert(piadaDto);
        return ResponseEntity.ok("Piadas inseridas com sucesso!");
    }

    @GetMapping
    public ResponseEntity<Piada> random() throws Exception {
        return ResponseEntity.ok(piadaService.random());
    }

}
