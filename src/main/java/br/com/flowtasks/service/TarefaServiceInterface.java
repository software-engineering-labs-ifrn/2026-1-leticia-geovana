package br.com.flowtasks.service;

import br.com.flowtasks.dto.TarefaEdicaoDto;
import br.com.flowtasks.dto.TarefaRequesteDto;
import br.com.flowtasks.dto.TarefaResponseDto;

import java.util.List;

public interface TarefaServiceInterface {
    List<TarefaResponseDto> listarTodasAsTarefas();
    void salvarTarefa(TarefaRequesteDto tarefa);
    void deletarTarefa(Long id);
    void atualizarTarefa(Long id, TarefaEdicaoDto tarefa);
    TarefaResponseDto listarTarefaPorId(Long id);
    void marcarTarefaComoConcluida(Long id);
}
