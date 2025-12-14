package com.exemplo.api.service;

import com.exemplo.api.model.Iniciativa;
import com.exemplo.api.repository.IniciativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IniciativaService {
    @Autowired
    private IniciativaRepository repository;

    public List<Iniciativa> findAll() {
        return repository.findAll();
    }

    public Iniciativa save(@NonNull Iniciativa iniciativa) {
        return repository.save(iniciativa);
    }

    public Optional<Iniciativa> findById(@NonNull Long id) {
        return repository.findById(id);
    }

    public boolean deleteById(@NonNull Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
