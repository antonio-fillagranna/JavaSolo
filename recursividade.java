public class recursividade {

    public static int calcularNumeroTriangular(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + calcularNumeroTriangular(n - 1);
        }
    }

    public static void imprimirTriangulo(int n) {
        if (n == 0) {
            return;
        } else {
            imprimirTriangulo(n - 1);
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Digite   o valor de n: ");
        int n = scanner.nextInt();

        int resultado = calcularNumeroTriangular(n);
        System.out.println("O " + n + "-ésimo número triangular é: " + resultado);
        System.out.println("O triângulo equivalente é:");
        imprimirTriangulo(n);
        scanner.close();

    }
}