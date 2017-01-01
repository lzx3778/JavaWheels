package singlePrograms;

import java.util.Scanner;

public class ExplainGPS {
	private static String systemEnter = "";
	private static String TimeInString = "";
	private static int Time = 0;
	private static int Hour = 0;
	private static int Min = 0;
	private static int Sec = 0;

	// input,can be replace by other input
	public static String Data() {
		System.out.println("Enter data:");
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		return a;
	}

	public ExplainGPS() {
		while (true) {
			/*
			 * use input,Data can be replace by other input but same name with
			 * input method
			 */
			systemEnter = Data();
			TimeInString = systemEnter.substring(systemEnter.indexOf("$GPRMC,") + 7, systemEnter.indexOf("."));
			try {
				// String to int
				Time = Integer.parseInt(TimeInString) + 80000;
			} catch (Exception e) {
				System.out.println("Error!wrong type!");
				continue;
			}
			// calculate hour , minute and second
			Hour = Time / 10000;
			Min = Time / 100 - Hour * 100;
			Sec = Time - ((Time / 100) * 100);
			// output
			System.out.println(Hour + ":" + Min + ":" + Sec);
		}
	}
}
