package tryPack;

/**
 * Created by lenovo on 2017-2-5.
 */
public class FallingObject {
    private static double sizeX;
    private static double sizeY;
    private static double velocity;
    private static double y;
    private static boolean flying;
    private static double bounceVelocity;

    public FallingObject(){
        //initialize values
        sizeX = 30;
        sizeY = 30;
        velocity = 0;
        y = 1;
        flying = false;
        bounceVelocity = 0;
    }

    public static double getSizeX() {
        return sizeX;
    }

    public static void setSizeX(double sizeX) {
        FallingObject.sizeX = sizeX;
    }

    public static double getSizeY() {
        return sizeY;
    }

    public static void setSizeY(double sizeY) {
        FallingObject.sizeY = sizeY;
    }

    public static double getVelocity() {
        return velocity;
    }

    public static void setVelocity(double velocity) {
        FallingObject.velocity = velocity;
    }

    public static double getY() {
        return y;
    }

    public static void setY(double y) {
        FallingObject.y = y;
    }

    public static boolean isFlying() {
        return flying;
    }

    public static void setFlying(boolean flying) {
        FallingObject.flying = flying;
    }

    public static double getBounceVelocity() {
        return bounceVelocity;
    }

    public static void setBounceVelocity(double bounceVelocity) {
        FallingObject.bounceVelocity = bounceVelocity;
    }
}
