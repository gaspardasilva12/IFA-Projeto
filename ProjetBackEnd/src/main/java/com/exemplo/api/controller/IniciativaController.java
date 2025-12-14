package com.exemplo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.api.model.Iniciativa;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/iniciativa")
public class IniciativaController {

    @Autowired
    private com.exemplo.api.service.IniciativaService service;

    @GetMapping
    public List<Iniciativa> listarTodas() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Iniciativa> criar(@RequestBody @Valid @NonNull Iniciativa iniciativa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(iniciativa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NonNull Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
