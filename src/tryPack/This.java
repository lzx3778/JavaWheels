package tryPack;

public class This {
	public This(){
		A a = new A("d");
		A b = new A(1);
	}
}
class A{
	public A(int i){
		this("Lzx");
		System.out.println(i);
	}
	public A(String s){
		System.out.println(s);
	}
}