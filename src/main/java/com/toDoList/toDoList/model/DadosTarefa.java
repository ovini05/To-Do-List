package com.toDoList.toDoList.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data

public class DadosTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;

    @Enumerated(EnumType.STRING)
    private String descricao;
    private StatusTarefa statusTarefa;
    private LocalDate dataCriacao = LocalDate.now();
    private LocalDate dataVencimento;
}
