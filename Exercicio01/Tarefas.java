package diome.java.Collections.exercicio01;

import java.util.ArrayList;
import java.util.List;

public class Tarefas {

	private List<Tarefa> listaTarefas = new ArrayList<Tarefa>();

	public Tarefas() {
		listaTarefas = new ArrayList<Tarefa>();
	}

	public Tarefas(List<Tarefa> tarefas) {
		this();

		this.listaTarefas = tarefas;
	}

	public void adicionarTarefa(String descricao) {
		listaTarefas.add(new Tarefa(descricao));
	}

	public void removerTarefa(String descricao) {

		List<Tarefa> tarefasParaRemover = new ArrayList<Tarefa>();

		for (var tarefa : listaTarefas) {

			if (tarefa.getNomeTarefa().toString() == descricao) {
				tarefasParaRemover.add(tarefa);
			}

		}

		listaTarefas.removeAll(tarefasParaRemover);

	}

	public Integer obterNumeroTotalTarefas() {
		return this.listaTarefas.size();
	}

	public String obterDescricoesTarefas() {
		return toString();
	}

	@Override
	public String toString() {

		StringBuilder str = new StringBuilder();

		for (var tarefa : listaTarefas) {
			str.append( tarefa.getNomeTarefa() + "\n" );
		}

		return str.toString();

	}

}