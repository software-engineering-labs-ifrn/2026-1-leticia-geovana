package br.com.flowtasks.entities;


import br.com.flowtasks.enums.Prioridade;
import br.com.flowtasks.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_tarefas")
public class TarefaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	private String descricao;

	@CreationTimestamp
	private LocalDate dataCriacao;
	private Date dataConclusao;
	@Enumerated(EnumType.ORDINAL)
	private Status statusTarefa;
	@Enumerated(EnumType.ORDINAL)
	private Prioridade prioridadeTarefa;
	@OneToMany(mappedBy = "tarefaPai", cascade = CascadeType.REMOVE)
	private List<SubTarefaEntity> subTarefas = new ArrayList<>();


	public TarefaEntity(Long id, String nome, String descricao, LocalDate dataCriacao, Date dataConclusao, Status statusTarefa, Prioridade prioridadeTarefa) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataConclusao = dataConclusao;
		this.statusTarefa = statusTarefa;
		this.prioridadeTarefa = prioridadeTarefa;
	}

	public TarefaEntity() {}


    public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public List<SubTarefaEntity> getSubTarefas() {
		return subTarefas;
	}

	public void setSubTarefas(List<SubTarefaEntity> subTarefas) {
		this.subTarefas = subTarefas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Status getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(Status statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

	public Prioridade getPrioridadeTarefa() {
		return prioridadeTarefa;
	}

	public void setPrioridadeTarefa(Prioridade prioridadeTarefa) {
		this.prioridadeTarefa = prioridadeTarefa;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		TarefaEntity that = (TarefaEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(dataCriacao, that.dataCriacao) && statusTarefa == that.statusTarefa && prioridadeTarefa == that.prioridadeTarefa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, descricao, dataCriacao, statusTarefa, prioridadeTarefa);
	}
}
