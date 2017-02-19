package tutorials.interfaceExample;

/**
 * Created by lenovo on 2016-11-25.
 */
public class cat implements pet {
	@Override
	public void talk() {
		System.out.print("I'm a cat");
	}
}
