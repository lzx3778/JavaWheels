package tryPack;

public class Extends {
	public Extends(){
		me m = new me("Lzx");
		m.talk();
		m.Talk();
		human h = new human("lzx");
	}
}
class human{
	public human(String s){
		System.out.println(s);
	}
	public static void talk(){
		System.out.println("I'm a human");
	}
}
class me extends human{
	private static String a;
	public me(String s) {
		super(s);
		// TODO Auto-generated constructor stub
		a = s + 1;
		s = a;
	}
	public static void Talk(){
		System.out.println(a);
	}
}