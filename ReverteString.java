import java.util.Scanner;

public class ReverteString {
	public static void main(String[] arg)
	{
	ReverteString rev=new ReverteString();
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter a string : ");
	String  str=sc.nextLine();	
	System.out.println("Reverse of a String  is : "+rev.reverse(str));
    sc.close();
	}
    static String reverse(String s) {
	String rev="";
	for(int j=s.length();j>0;--j) {
	rev=rev+(s.charAt(j-1)); 
	}
	return rev;
	}
}