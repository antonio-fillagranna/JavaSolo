/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snak;

/**
 *
 * @author Antonio
 */
class pattern  
  
   public static void main(String[] args)  
 {  
   int size = 0;  
       Character c;  
       System.out.println();  
       size = 5;  
       int i, j, k;  
       for (i = 0; i < size + 1; i++) { for (j = size; j > i; j--) {  
               System.out.print(" ");  
           }  
           for (k = 0; k < (2 * i - 1); k++) {  
               System.out.print("*");  
           }  
           System.out.println();  
         }  
   }  
   }  