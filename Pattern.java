package printnicepattern;

 public class Pattern  
{  
    public static void main(String[] args)  
    {   int i ,j;  
        int n = 5;  
            for(i = n; i>0 ; i-- )  
            {  
                 for(j = 1; j<=i ; j++)  
                    {  
                        System.out.print(j);  
                    }  
                         System.out.println("");  
            }  
    }  
}  