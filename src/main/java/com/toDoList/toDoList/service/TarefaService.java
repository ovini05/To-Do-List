package com.toDoList.toDoList.service;

import com.toDoList.toDoList.model.DadosTarefa;
import com.toDoList.toDoList.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public DadosTarefa criarTarefa(DadosTarefa tarefa) {
        return repository.save(tarefa);
    }

    public List<DadosTarefa> listarTarefa() {
        return repository.findAll();
    }

    public Optional<DadosTarefa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluirTarefa(Long id) {
        repository.deleteById(id);
    }

}
