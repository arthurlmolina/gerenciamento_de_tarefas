package com.example.gerenciamento_de_tarefas.Repository;

import com.example.gerenciamento_de_tarefas.Models.TarefaModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModels, Long> {
}
