package com.exemplo.api.controller;

import com.exemplo.api.dto.AtividadeDTO;
import com.exemplo.api.model.Atividade;
import com.exemplo.api.service.AtividadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping("/{iniciativaId}")
    public ResponseEntity<List<Atividade>> listarPorIniciativa(@PathVariable @NonNull Long iniciativaId) {
        return ResponseEntity.ok(atividadeService.findByIniciativaId(iniciativaId));
    }

    @PostMapping
    public ResponseEntity<Atividade> criar(@RequestBody @Valid @NonNull AtividadeDTO dto) {
        Atividade created = atividadeService.createFromDto(dto);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NonNull Long id) {
        if (atividadeService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
