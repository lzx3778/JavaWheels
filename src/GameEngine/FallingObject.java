package GameEngine;

/**
 * Created by lenovo on 2017-2-5.
 */
public class FallingObject {

    private static double sizeX;
    private static double sizeY;
    private static double velocity;
    private static double CenterY;
    private static boolean flying;

    public FallingObject(double width, double height, double initVelocity, double initCenterY){

        //initialize values
        sizeX = width;
        sizeY = height;
        velocity = initVelocity;
        CenterY = initCenterY;
        flying = true;

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

    public static double getCenterY() {
        return CenterY;
    }

    public static void setCenterY(double CenterY) {
        FallingObject.CenterY = CenterY;
    }

    public static boolean isFlying() {
        return flying;
    }

    public static void setFlying(boolean flying) {
        FallingObject.flying = flying;
    }

}
