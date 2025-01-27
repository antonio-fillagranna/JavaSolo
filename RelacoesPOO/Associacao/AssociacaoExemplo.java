public class AssociacaoExemplo {
    public static void main(String[] args) {
        Professor professor = new Professor("Dr. Silva");
        Aluno aluno = new Aluno("João");

        aluno.assistirAula(professor);
    }
}