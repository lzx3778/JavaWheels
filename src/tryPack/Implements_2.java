package tryPack;

import tryPack.cl.in;

public class Implements_2 implements in{
	public static void main(String[] args){
		cl c = new cl();
		int A = c.v();
		System.out.println(A);
	}
	public int i(int c) {
		System.out.println(c);
		return 2 * c;
	}
}
class cl{
	public interface in{
		int i(int c);
	}
	public int v(){
		Implements_2 I = new Implements_2();
		int a = I.i(2);
		return a;
	}
}