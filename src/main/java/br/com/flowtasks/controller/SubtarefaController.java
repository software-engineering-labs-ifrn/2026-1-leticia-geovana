package br.com.flowtasks.controller;

import br.com.flowtasks.dto.*;
import br.com.flowtasks.service.SubTarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subtarefas")
public class SubtarefaController {

    @Autowired
    private SubTarefaService subTarefaService;

    @GetMapping
    public List<SubTarefaResponseDto> listarTodasSubTarefas() {
        List<SubTarefaResponseDto> todasAsSubtarefas = subTarefaService.listarTodasAsSubTarefas();
        return todasAsSubtarefas;
    }

    @PostMapping
    public ResponseEntity<Void> salvarSubTarefa(@RequestBody SubTarefaRequestDto subTarefa){
        subTarefaService.salvarSubTarefa(subTarefa);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarSubTarefa(@PathVariable Long id){
        subTarefaService.deletarSubTarefa(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/{id}/atualizar")
    public ResponseEntity<Void> atualizarSubTarefa(@RequestBody SubTarefaEdicaoDto subTarefa, @PathVariable Long id){
        subTarefaService.atualizarSubTarefa(id,subTarefa);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public SubTarefaResponseDto listarSubTarefaPorId(@PathVariable Long id){
        SubTarefaResponseDto subTarefaBuscada = subTarefaService.listarSubTarefaPorId(id);
        return  subTarefaBuscada;
    }
}
