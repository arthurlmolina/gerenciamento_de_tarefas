package com.example.gerenciamento_de_tarefas.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.apache.catalina.valves.rewrite.RewriteCond;

import javax.swing.text.StyledEditorKit;
import java.time.LocalDateTime;

@Entity
public class TarefaModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDateTime dataVencimento;
    private Boolean concluido;

    public TarefaModels() {
    }

    public TarefaModels(String descricao, LocalDateTime dataVencimento, Boolean concluido) {
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.concluido = concluido;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }
}
