
import java.util.Scanner;

public class fibonacci {
    public static int fibonacci(int n){
        if(n<=1){
            return n;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o termo n que deseja calcular = ");
        int n = scan.nextInt();
        int resultado = fibonacci(n);
        System.out.println("O " + n + "-esimo termo da sequencia Fibonacci eh: " + resultado);
        scan.close();
    }
}
