package wheels.no_Graphic;

import java.util.Scanner;

public class Enter {
	public static double E_double() {
		double i = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				i = scan.nextDouble();
				scan.close();
				return i;
			} catch (Exception e) {
				Warning.EnterFault("number");
				continue;
			}
		}
	}

	public static int E_int() {
		int i = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				i = scan.nextInt();
				scan.close();
				return i;
			} catch (Exception e) {
				Warning.EnterFault("number");
				continue;
			}
		}
	}
}
