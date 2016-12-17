package tryPack;

public class ChangeAble {
	public static void main(String[] args){
		p(13);
	}
	static void p(Object... o){
		System.out.printf("%d", o);
	}
}
