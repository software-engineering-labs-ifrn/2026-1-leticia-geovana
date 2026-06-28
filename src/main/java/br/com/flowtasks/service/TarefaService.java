package br.com.flowtasks.service;

import java.util.List;
import br.com.flowtasks.dto.TarefaEdicaoDto;
import br.com.flowtasks.dto.TarefaRequesteDto;
import br.com.flowtasks.dto.TarefaResponseDto;
import br.com.flowtasks.entities.TarefaEntity;
import br.com.flowtasks.enums.Status;
import br.com.flowtasks.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	

	@Transactional(readOnly = true)
	public List<TarefaResponseDto> listarTodasAsTarefas(){
		
		List<TarefaEntity> respostaTodasTarefas = tarefaRepository.findAll();
		
		List<TarefaResponseDto> todasAsTarefas = respostaTodasTarefas.stream().map(tarefa -> new TarefaResponseDto(tarefa)).toList();

		return  todasAsTarefas;
	}
	
	
	public void salvarTarefa(TarefaRequesteDto tarefa) {
		TarefaEntity novaTarefa = new TarefaEntity();
		novaTarefa.setNome(tarefa.getNome());
		tarefaRepository.save(novaTarefa);
	}
	
	
	public void deletarTarefa(Long id) {
		TarefaEntity tarefaBuscada = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

		tarefaRepository.delete(tarefaBuscada);
	}
	
	
	public void atualizarTarefa(Long id, TarefaEdicaoDto tarefa) {
		TarefaEntity tarefaBuscada = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

		tarefaBuscada.setNome(tarefa.getNome());
		tarefaBuscada.setDescricao(tarefa.getDescricao());
		tarefaBuscada.setDataConclusao(tarefa.getDataConclusao());
		tarefaBuscada.setStatusTarefa(tarefa.getStatusTarefa());
		tarefaBuscada.setPrioridadeTarefa(tarefa.getPrioridadeTarefa());

		tarefaRepository.save(tarefaBuscada);

	}

	@Transactional(readOnly = true)
	public TarefaResponseDto listarTarefaPorId(Long id) {
		TarefaEntity tarefaBuscada = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
		TarefaResponseDto tarefa = new TarefaResponseDto(tarefaBuscada);

		return tarefa;
	}


	public void marcarTarefaComoConcluida(Long id) {
		TarefaEntity tarefaBuscada = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

		tarefaBuscada.setStatusTarefa(Status.CONCLUIDO);

		tarefaRepository.save(tarefaBuscada);
	}
	
}
