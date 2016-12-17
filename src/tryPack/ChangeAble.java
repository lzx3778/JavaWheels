package tryPack;

public class ChangeAble {
	public ChangeAble(){
		p(13);
	}
	static void p(Object... o){
		System.out.printf("%d", o);
	}
}
