import entities.triangle;
import java.util.Locale;
import java.util.Scanner;
 

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //double xA, xB, xC, yA, yB, yC;
 
        triangle x, y;
        x = new triangle();
        y = new triangle();
 
        System.out.println("Enter the measures of triangle X: ");
        //xA = sc.nextDouble();
        //xB = sc.nextDouble();
        //xC = sc.nextDouble();
 
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();
       
        System.out.println("Enter the measures of triangle Y: ");
        /*yA = sc.nextDouble();
        yB = sc.nextDouble();
        yC = sc.nextDouble();*/
       
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();
   
        /*double p = (x.a + x.b + x.c) / 2.0;
        double areaX = Math.sqrt(p * (p - x.a) * (p - x.b) * (p - x.c));
        p = (y.a + y.b + y.c) / 2.0;*/
       
        double areaX = x.area();
       
        /*double p = (x.a + x.b + x.c) / 2.0;
        double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));
        p = (y.a + y.b + y.c) / 2.0;*/
       
        double areaY = y.area();
 
        System.out.printf("Triangle X area: %.4f%n", areaX);
        System.out.printf("Triangle Y area: %.4f%n", areaY);
       
 
        if (areaX > areaY) {
            System.out.println("Larger area: X");
        } else {
            System.out.println("Larger area: Y");
        }
        sc.close();
    }
}
