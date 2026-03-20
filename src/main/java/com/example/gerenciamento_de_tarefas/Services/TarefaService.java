package com.example.gerenciamento_de_tarefas.Services;


import com.example.gerenciamento_de_tarefas.Models.TarefaModels;
import com.example.gerenciamento_de_tarefas.Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaModels adicionar(TarefaModels tarefaModels){
        return tarefaRepository.save(tarefaModels);
    }

    public List<TarefaModels> buscarTodos(){
        return tarefaRepository.findAll();
    }

    public TarefaModels buscarPorId(Long id){
        return tarefaRepository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        tarefaRepository.deleteById(id);
    }

    public TarefaModels atualizar(Long id, TarefaModels tarefaModels){
        TarefaModels novaTarefa = tarefaRepository.findById(id).orElse(null);
        novaTarefa.setDescricao(tarefaModels.getDescricao());
        novaTarefa.setDataVencimento(tarefaModels.getDataVencimento());
        novaTarefa.setConcluido(tarefaModels.getConcluido());
        return tarefaRepository.save(novaTarefa);
    }
}
