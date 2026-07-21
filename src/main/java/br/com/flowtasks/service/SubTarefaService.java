package br.com.flowtasks.service;

import br.com.flowtasks.dto.SubTarefaEdicaoDto;
import br.com.flowtasks.dto.SubTarefaRequestDto;
import br.com.flowtasks.dto.SubTarefaResponseDto;
import br.com.flowtasks.entities.SubTarefaEntity;
import br.com.flowtasks.repository.SubTarefaRepository;
import br.com.flowtasks.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;
import br.com.flowtasks.enums.Status;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SubTarefaService implements SubTarefaServiceInterface {

	@Autowired
	private SubTarefaRepository subTarefaRepository;

	@Autowired
	private TarefaRepository tarefaRepository;
	
	
	public List<SubTarefaResponseDto> listarTodasAsSubTarefas(){
		
		List<SubTarefaEntity> respostaTodasSubTarefas = subTarefaRepository.findAll();
		
		List<SubTarefaResponseDto> todasAsSubTarefas = respostaTodasSubTarefas.stream().map(subTarefa -> new SubTarefaResponseDto(subTarefa)).toList();

		return  todasAsSubTarefas;
	}
	
	
	public void salvarSubTarefa(SubTarefaRequestDto subTarefa) {
		SubTarefaEntity novaTarefa = new SubTarefaEntity();
		novaTarefa.setNome(subTarefa.getNome());
		novaTarefa.setTarefaPai(tarefaRepository.findById(subTarefa.getTarefaPaiId())
				.orElseThrow(() -> new RuntimeException("Tarefa pai não encontrada")));
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
	
	public SubTarefaResponseDto listarSubTarefaPorId(Long id) {
		SubTarefaEntity tarefaBuscada = subTarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
		SubTarefaResponseDto subTarefa = new SubTarefaResponseDto(tarefaBuscada);

		return subTarefa;
	}

	@Transactional(readOnly = true)
	public List<SubTarefaResponseDto> listarSubTarefasPorTarefaPai(Long tarefaPaiId) {
		List<SubTarefaEntity> subTarefas = subTarefaRepository.findByTarefaPaiId(tarefaPaiId);
		return subTarefas.stream().map(SubTarefaResponseDto::new).toList();
	}

	@Transactional
 	public SubTarefaResponseDto concluirProximaSubTarefa(Long tarefaPaiId) {

 		List<SubTarefaEntity> pendentes = subTarefaRepository.findByTarefaPaiIdAndStatusTarefaOrderByDataCriacaoAsc(tarefaPaiId, Status.EM_ANDAMENTO);

 		if (pendentes.isEmpty()) {
 			throw new RuntimeException("Não há subtarefas pendentes na fila para esta tarefa.");
 		}

 		Queue<SubTarefaEntity> filaDeSubTarefas = new LinkedList<>(pendentes);

 		SubTarefaEntity proximaSubTarefa = filaDeSubTarefas.poll();

 		proximaSubTarefa.setStatusTarefa(Status.CONCLUIDO);
 		proximaSubTarefa.setDataConclusao(new Date());

 		subTarefaRepository.save(proximaSubTarefa);

 		return new SubTarefaResponseDto(proximaSubTarefa);
 	}
 	
 	public SubTarefaResponseDto peekProximaSubTarefa(Long tarefaPaiId) {
 	    SubTarefaEntity proxima = subTarefaRepository
 	        .findTopByTarefaPaiIdAndStatusTarefaOrderByDataCriacaoAsc(tarefaPaiId, Status.EM_ANDAMENTO);
 	    
 	    if (proxima == null) {
 	        throw new RuntimeException("Não há subtarefas pendentes na fila para esta tarefa.");
 	    }
 	    
 	    return new SubTarefaResponseDto(proxima);
 	}
 	
 }
