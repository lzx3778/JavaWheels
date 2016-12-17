package tryPack;
import java.util.*;
public class inputNumber{
	public static void main(String[] args){
		int a = 0;
		while(true){
			System.out.println("Enter a number:");
			try{
				Scanner scan = new Scanner(System.in);
				a = scan.nextInt();
				break;
			}catch(Exception e){
				System.out.println("that's not a number");
				continue;
			}
		}
		System.out.println(a);
	}
}
