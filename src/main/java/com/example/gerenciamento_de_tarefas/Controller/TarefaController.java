package com.example.gerenciamento_de_tarefas.Controller;


import com.example.gerenciamento_de_tarefas.Models.TarefaModels;
import com.example.gerenciamento_de_tarefas.Services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModels> cadastrar(@RequestBody TarefaModels tarefaModels){
        TarefaModels tarefa = tarefaService.adicionar(tarefaModels);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tarefa.getId())
                .toUri();
        return ResponseEntity.created(uri).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefaModels>> listaTodos(){
        List<TarefaModels> request =tarefaService.buscarTodos();
        return ResponseEntity.ok(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModels> buscaPorId(@PathVariable Long id){
        TarefaModels tarefa = tarefaService.buscarPorId(id);
        return ResponseEntity.ok(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModels> atualizar(@PathVariable Long id,@RequestBody TarefaModels tarefaModels){
        TarefaModels tarefaAtualizada = tarefaService.atualizar(id,tarefaModels);
        return ResponseEntity.ok(tarefaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TarefaModels> deletar(@PathVariable Long id){
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
