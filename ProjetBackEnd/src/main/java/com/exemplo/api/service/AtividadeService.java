package com.exemplo.api.service;

import com.exemplo.api.dto.AtividadeDTO;
import com.exemplo.api.model.Atividade;
import com.exemplo.api.model.Iniciativa;
import com.exemplo.api.repository.AtividadeRepository;
import com.exemplo.api.repository.IniciativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {
    @Autowired
    private AtividadeRepository atividadeRepository;
    @Autowired
    private IniciativaRepository iniciativaRepository;

    public List<Atividade> findByIniciativaId(@NonNull Long iniciativaId) {
        return atividadeRepository.findByIniciativa_Id(iniciativaId);
    }

    public Atividade createFromDto(@NonNull AtividadeDTO dto) {
        Long iniciativaId = dto.getIniciativaId();
        if (iniciativaId == null) {
            return null;
        }
        Optional<Iniciativa> iniciativaOpt = iniciativaRepository.findById(iniciativaId);
        if (iniciativaOpt.isPresent()) {
            Atividade atividade = new Atividade();
            atividade.setTitulo(dto.getTitulo());
            atividade.setData(dto.getData());
            atividade.setDescricao(dto.getDescricao());
            atividade.setIniciativa(iniciativaOpt.get());
            return atividadeRepository.save(atividade);
        }
        return null;
    }

    public boolean deleteById(@NonNull Long id) {
        if (atividadeRepository.existsById(id)) {
            atividadeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
