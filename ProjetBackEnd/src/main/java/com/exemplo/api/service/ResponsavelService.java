package com.exemplo.api.service;

import com.exemplo.api.model.Iniciativa;
import com.exemplo.api.model.Responsavel;
import com.exemplo.api.repository.IniciativaRepository;
import com.exemplo.api.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponsavelService {
    @Autowired
    private ResponsavelRepository responsavelRepository;
    @Autowired
    private IniciativaRepository iniciativaRepository;

    public Optional<Responsavel> findById(@NonNull Long id) {
        return responsavelRepository.findById(id);
    }

    public Responsavel save(@NonNull Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    public Optional<Responsavel> associateToIniciativa(@NonNull Long responsavelId, @NonNull Long iniciativaId) {
        Optional<Responsavel> respOpt = responsavelRepository.findById(responsavelId);
        Optional<Iniciativa> inicOpt = iniciativaRepository.findById(iniciativaId);
        if (respOpt.isPresent() && inicOpt.isPresent()) {
            Responsavel responsavel = respOpt.get();
            responsavel.setIniciativa(inicOpt.get());
            return Optional.of(responsavelRepository.save(responsavel));
        }
        return Optional.empty();
    }

    public boolean deleteById(@NonNull Long id) {
        if (responsavelRepository.existsById(id)) {
            responsavelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
