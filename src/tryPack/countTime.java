package tryPack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class countTime {
	public countTime(){
		Date date = new Date();
		DateFormat format = new SimpleDateFormat();
		String s = format.format(date);
		System.out.println(s);
	}
}
