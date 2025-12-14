package com.exemplo.api.repository;

import com.exemplo.api.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    List<Atividade> findByIniciativa_Id(Long iniciativaId);
}
