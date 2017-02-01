package tutorials;

import java.util.Scanner;

public class HasNext {

	public HasNext() {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String string = scanner.nextLine();
			System.out.println(string);
		}
	}
}
