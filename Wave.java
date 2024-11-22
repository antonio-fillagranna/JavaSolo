

class Wave { 

	static void pattern(int wave_height, int wave_length) 
	{ 
		int i, j, k, e, n, count, x; 
		e = 2; 
		x = 1; 
 
		for (i = 0; i < wave_height; i++) 
		{ 
			for (j = wave_height; j <= wave_height + i; j++) 
				System.out.print(" "); 

			for (count = 1; count <= wave_length; count++) 
			{ 

				for (n = (wave_height + wave_height - 2); n >= x; n--) 
					System.out.print(" "); 
			
				for (k = 1; k <= e; k++) 
				{ 
					if (k == 1) 
						System.out.print("/"); 
					else if (k == e) 
						System.out.print("\\"); 
					else
						System.out.print(" "); 
				} 
			} 

			x = x + 2; 
			e = e + 2; 
			
			System.out.println(); 
		} 
	} 

	public static void main(String args[]) 
	{   
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Altura:");
        //int wave_height = scan.nextInt();
        //System.out.println("Largura");
        //int wave_length = scan.nextInt();
		int wave_height = 2; 
		int wave_length = 10; 

		pattern(wave_height, wave_length); 
        //scan.close();
	} 
} 