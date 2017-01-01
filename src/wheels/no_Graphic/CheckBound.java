package wheels.no_Graphic;

public class CheckBound {

	public static boolean IsBiggerThanZero(int testNumber) {
		if (testNumber > 0) {
			return true;
		}
		return false;
	}

	public static boolean IsNegetive(int testNumber) {
		if (testNumber > 0) {
			return false;
		}
		return true;
	}

	public static boolean IsPossitive(int testNumber) {
		if (testNumber < 0) {
			return false;
		}
		return true;
	}
}
