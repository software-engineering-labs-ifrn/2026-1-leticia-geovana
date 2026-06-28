package br.com.flowtasks.service;

import br.com.flowtasks.dto.SubTarefaEdicaoDto;
import br.com.flowtasks.dto.SubTarefaRequestDto;
import br.com.flowtasks.dto.SubTarefaResponseDto;
import br.com.flowtasks.entities.SubTarefaEntity;
import br.com.flowtasks.repository.SubTarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SubTarefaService {

	@Autowired
	private SubTarefaRepository subTarefaRepository;
	
	
	public List<SubTarefaResponseDto> listarTodasAsSubTarefas(){
		
		List<SubTarefaEntity> respostaTodasSubTarefas = subTarefaRepository.findAll();
		
		List<SubTarefaResponseDto> todasAsSubTarefas = respostaTodasSubTarefas.stream().map(subTarefa -> new SubTarefaResponseDto(subTarefa)).toList();

		return  todasAsSubTarefas;
	}
	
	
	public void salvarSubTarefa(SubTarefaRequestDto subTarefa) {
		SubTarefaEntity novaTarefa = new SubTarefaEntity();
		novaTarefa.setNome(subTarefa.getNome());
		subTarefaRepository.save(novaTarefa);
	}
	
	
	public void deletarSubTarefa(Long id) {
		SubTarefaEntity subTarefaBuscada = subTarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

		subTarefaRepository.delete(subTarefaBuscada);
	}
	
	
	public void atualizarSubTarefa(Long id, SubTarefaEdicaoDto tarefa) {
		SubTarefaEntity subTarefaBuscada = subTarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

		subTarefaBuscada.setNome(tarefa.getNome());
		subTarefaBuscada.setDescricao(tarefa.getDescricao());
		subTarefaBuscada.setDataConclusao(tarefa.getDataConclusao());
		subTarefaBuscada.setStatusTarefa(tarefa.getStatusTarefa());
		subTarefaBuscada.setPrioridadeTarefa(tarefa.getPrioridadeTarefa());

		subTarefaRepository.save(subTarefaBuscada);

	}
	
	public SubTarefaResponseDto listarTarefaPorId(Long id) {
		SubTarefaEntity tarefaBuscada = subTarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
		SubTarefaResponseDto subTarefa = new SubTarefaResponseDto(tarefaBuscada);

		return subTarefa;
	}
	
}
