package tutorials;

import tutorials.Tr.*;

public class Implements {
	public Implements() {
		IN in = new IN();
		in.pr(1);
	}
}

class IN implements Tr {
	public void pr(int c) {
		System.out.println("lzx");
	}
}

interface Tr {
	void pr(int c);
}