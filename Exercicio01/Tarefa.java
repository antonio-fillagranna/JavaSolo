package diome.java.Collections.exercicio01;

public class Tarefa {

	private String nomeTarefa;

	public Tarefa() {
		this.setNomeTarefa("");
	}

	public Tarefa(String nomeTarefa) {
		this.setNomeTarefa(nomeTarefa);
	}

	public String tarefasParaRemover() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	
	public String getNomeTarefa() {
		return nomeTarefa;
	}

	@Override
	public String toString() {
		return "Tarefa [nomeTarefa=" + nomeTarefa + "]\n";
	}

}