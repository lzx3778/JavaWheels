package tryPack;
import java.io.*;
import java.util.*;
public class ToHex {
	public static String toHexString(String s){
		String str = "";
		for (int i = 0;i < s.length();i++){
			int ch = (int)s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}
	public ToHex(){
		String a = toHexString("Castiel").toUpperCase();
		System.out.println(a);
	}
}