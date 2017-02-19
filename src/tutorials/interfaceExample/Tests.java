package tutorials.interfaceExample;

/**
 * Created by lenovo on 2016-11-25.
 */
public class Tests {
	public static void main(String[] args) {
		pet dog = new dog();
		pet cat = new cat();

		test t = new test();
		t.buy(cat);
		t.buy(dog);
	}
}