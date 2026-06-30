package br.com.flowtasks.repository;

import br.com.flowtasks.entities.SubTarefaEntity;
import br.com.flowtasks.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubTarefaRepository extends JpaRepository<SubTarefaEntity, Long> {
    List<SubTarefaEntity> findByTarefaPaiIdAndStatusTarefaOrderByDataCriacaoAsc(Long tarefaPaiId, Status statusTarefa);
    List<SubTarefaEntity> findByTarefaPaiId(Long tarefaPaiId);
    SubTarefaEntity findTopByTarefaPaiIdAndStatusTarefaOrderByDataCriacaoAsc(Long tarefaPaiId, Status statusTarefa);
}
