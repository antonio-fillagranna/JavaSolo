import java.io.*;  
public class P4 {
	static void spiralPrint(int m, int n, int a[][])  
	{  
	int i, k = 0, l = 0;  
	/* k - starting row index 
	m - ending row index 
	l - starting column index 
	n - ending column index 
	i - iterator 
	*/  
	while (k < m && l < n)   
	{  
	//prints the first row from the remaining rows  
	for (i = l; i < n; ++i)   
	{  
	System.out.print(a[k][i] + " ");  
	}  
	k++;  
	  
	//prints the last column from the remaining columns  
	for (i = k; i < m; ++i)   
	{  
	System.out.print(a[i][n - 1] + " ");  
	}  
	n--;  
	//prints the last row from the remaining rows   
	if (k < m)   
	{  
	for (i = n - 1; i >= l; --i)   
	{  
	System.out.print(a[m - 1][i] + " ");  
	}  
	m--;  
	}  
	//prints the first column from the remaining columns  
	if (l < n)   
	{  
	for (i = m - 1; i >= k; --i)   
	{  
	System.out.print(a[i][l] + " ");  
	}  
	l++;  
	}  
	}  
	}  
	//driver Code  
	public static void main(String args[])  
	{  
	int row = 3;  
	int col = 6;  
	//array to print in spiral form  
	int arr[][] = { { 10, 20, 30, 40, 50, 60 }, { 70, 80, 90, 100, 110, 120 }, { 130, 140, 150, 160, 170, 180 } };  
	//function Calling  
	spiralPrint(row, col, arr);  
	}  
}
