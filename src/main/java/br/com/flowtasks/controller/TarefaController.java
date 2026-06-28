package br.com.flowtasks.controller;

import java.util.List;
import br.com.flowtasks.dto.TarefaEdicaoDto;
import br.com.flowtasks.dto.TarefaRequesteDto;
import br.com.flowtasks.dto.TarefaResponseDto;
import br.com.flowtasks.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping
	public List<TarefaResponseDto> listarTodasAsTarefas(){
		List<TarefaResponseDto> todasAsTarefas= tarefaService.listarTodasAsTarefas();
		
		return todasAsTarefas;
	}
	
	@PostMapping
	public ResponseEntity<Void> salvarTarefa(@RequestBody TarefaRequesteDto tarefa){
		tarefaService.salvarTarefa(tarefa);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarTarefa(@PathVariable Long id){
		tarefaService.deletarTarefa(id);
		return ResponseEntity.ok().build();
	}
	
	@PatchMapping(value = "/{id}/atualizar")
	public ResponseEntity<Void> atualizarTarefa(@RequestBody TarefaEdicaoDto tarefa, @PathVariable Long id){
		tarefaService.atualizarTarefa(id,tarefa);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/{id}")
	public TarefaResponseDto listarTarefaPorId(@PathVariable Long id){
		TarefaResponseDto tarefaBuscada = tarefaService.listarTarefaPorId(id);
		return  tarefaBuscada;
	}
}

