package br.com.flowtasks.service;

import br.com.flowtasks.dto.SubTarefaEdicaoDto;
import br.com.flowtasks.dto.SubTarefaRequestDto;
import br.com.flowtasks.dto.SubTarefaResponseDto;

import java.util.List;

public interface SubTarefaServiceInterface {
    List<SubTarefaResponseDto> listarTodasAsSubTarefas();
    void salvarSubTarefa(SubTarefaRequestDto subTarefa);
    void deletarSubTarefa(Long id);
    void atualizarSubTarefa(Long id, SubTarefaEdicaoDto subTarefa);
    SubTarefaResponseDto listarSubTarefaPorId(Long id);
    List<SubTarefaResponseDto> listarSubTarefasPorTarefaPai(Long tarefaPaiId);
    SubTarefaResponseDto concluirProximaSubTarefa(Long tarefaPaiId);
    SubTarefaResponseDto peekProximaSubTarefa(Long tarefaPaiId);
}
