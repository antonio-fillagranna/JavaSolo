
import entities.calcm;
import java.util.Scanner;

public class Mediaescolar {
    public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    calcm media;
    media= new calcm();
    calcm.n1=scan.nextDouble();
    calcm.n2=scan.nextDouble();
    calcm.n3=scan.nextDouble();
    calcm.n4=scan.nextDouble();
    double r = calcm.calcula();
    System.out.println("media = " + r);
    
    if (r>=7){
        System.out.println("aprovado");
    }else{
        System.out.println("reprovado");
    }
    scan.close();
    }

}