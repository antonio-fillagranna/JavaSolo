import java.util.List;

class Universidade {
    private String nome;
    private List<Departamento> departamentos;

    public Universidade(String nome, List<Departamento> departamentos) {
        this.nome = nome;
        this.departamentos = departamentos;
    }

    public void listarDepartamentos() {
        System.out.println("Departamentos da Universidade " + nome + ":");
        for (Departamento dep : departamentos) {
            System.out.println("- " + dep.getNome());
        }
    }
}