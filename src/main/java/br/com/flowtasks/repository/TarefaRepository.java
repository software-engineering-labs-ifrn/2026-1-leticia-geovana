package br.com.flowtasks.repository;

import br.com.flowtasks.entities.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Long>{

}
