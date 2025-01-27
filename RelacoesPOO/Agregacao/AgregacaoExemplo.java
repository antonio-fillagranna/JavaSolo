import java.util.Arrays;

public class AgregacaoExemplo {
    public static void main(String[] args) {
        Departamento d1 = new Departamento("Ciência da Computação");
        Departamento d2 = new Departamento("Engenharia Mecânica");

        Universidade universidade = new Universidade("Universidade Federal", Arrays.asList(d1, d2));
        universidade.listarDepartamentos();
    }
}