package tutorials;

public class StringOnPosition {
	public StringOnPosition() {
		String s = "lzx";
		System.out.println(" " + s);
		char[] ch = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			ch[i] = a;
			System.out.println(a);
		}
	}
}
