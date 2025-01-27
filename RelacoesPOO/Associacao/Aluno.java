class Aluno {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void assistirAula(Professor professor) {
        System.out.println(nome + " está assistindo à aula do professor " + professor.getNome());
    }
}