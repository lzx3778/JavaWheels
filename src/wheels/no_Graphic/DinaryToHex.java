package wheels.no_Graphic;

import java.util.*;
public class DinaryToHex {
	public static void main(String[] args){
		System.out.println("Enter a integer:");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		int num = 0;
		String Nans = "";
		String ans = "";
 		
		try{
			num = Integer.parseInt(str);
		}catch(Exception e){
			System.out.println("Number please");
			return;
		}
		
		while(num > 0){
			Nans = Nans + (num % 2);
			num = num / 2;
		}
		for(int i = Nans.length() - 1;i >= 0;i--){
			ans = ans + Nans.charAt(i);
		}
		
		System.out.println(ans);
	}
}