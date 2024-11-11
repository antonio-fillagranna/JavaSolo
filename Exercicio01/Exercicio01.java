package diome.java.Collections.exercicio01;

public class Exercicio01 {
	public static void main(String[] args) {

	var tarefas = new Tarefas();
	
	tarefas.adicionarTarefa("Revisão Java");
	tarefas.adicionarTarefa("Aprender Spring");
	tarefas.adicionarTarefa("Aprender Angular");
	
	tarefas.adicionarTarefa("Aprender BootStrap");
	tarefas.adicionarTarefa("Aprender BootStrap");
	tarefas.adicionarTarefa("Aprender BootStrap");
	
	tarefas.removerTarefa("Aprender BootStrap");
	
	
	System.out.printf( "Quantida de Registros : %s \n\n", tarefas.obterNumeroTotalTarefas());
	
	System.out.println( tarefas.toString() );
	
	
	}
}