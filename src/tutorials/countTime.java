package tutorials;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class countTime {
	public static void time(String a) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat(a);
		String s = format.format(date);
		System.out.println("\n" + s + "\n");
	}
}
