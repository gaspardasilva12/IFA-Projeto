package com.exemplo.api.controller;

import com.exemplo.api.model.Responsavel;
import com.exemplo.api.service.ResponsavelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {
    @Autowired private ResponsavelService responsavelService;

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> buscarPorId(@PathVariable @NonNull Long id) {
        return responsavelService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Responsavel> criar(@RequestBody @Valid @NonNull Responsavel responsavel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelService.save(responsavel));
    }

    @PostMapping("/{responsavelId}/iniciativa/{iniciativaId}")
    public ResponseEntity<Responsavel> associar(@PathVariable @NonNull Long responsavelId, @PathVariable @NonNull Long iniciativaId) {
        return responsavelService.associateToIniciativa(responsavelId, iniciativaId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NonNull Long id) {
        if (responsavelService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
