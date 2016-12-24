package tryPack;

import java.awt.print.Printable;

public class Calculations {

	public static void main(String[] args) {
		int a = 0;
		print(a);
		
		
		a ++;
		print(a);
		
//		don't add one
		a = a ++;
		print(a);
		
		
		++ a;
		print(a);
		
		
		a = ++ a;
		print(a);
	}
	
	public static void print(int i){
		System.out.println(i);
	}
}
