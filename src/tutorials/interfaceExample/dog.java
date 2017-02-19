package tutorials.interfaceExample;

/**
 * Created by lenovo on 2016-11-25.
 */
public class dog implements pet {
	@Override
	public void talk() {
		System.out.print("I'm a dog");
	}
}
