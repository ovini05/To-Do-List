package com.toDoList.toDoList.controller;

import com.toDoList.toDoList.model.DadosTarefa;
import com.toDoList.toDoList.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<DadosTarefa> criarTarefa(@RequestBody DadosTarefa tarefa) {
        return ResponseEntity.ok(service.criarTarefa(tarefa));
    }

    @GetMapping()
    public ResponseEntity<List<DadosTarefa>> listarTarefa() {
        return ResponseEntity.ok(service.listarTarefa());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosTarefa> buscarTarefa(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Long id) {
        service.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    }


}
