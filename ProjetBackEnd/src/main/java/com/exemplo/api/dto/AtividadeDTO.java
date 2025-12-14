package com.exemplo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class AtividadeDTO {
    @NotBlank(message = "Título é obrigatório")
    private String titulo;
    
    @NotNull(message = "Data é obrigatória")
    private LocalDate data;
    
    private String descricao;
    
    @NotNull(message = "ID da iniciativa é obrigatório")
    private Long iniciativaId;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIniciativaId() {
        return iniciativaId;
    }

    public void setIniciativaId(Long iniciativaId) {
        this.iniciativaId = iniciativaId;
    }
}
