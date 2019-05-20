package test;

import entity.Coordinate;
import entity.ScreenSize;
import utils.Log;

public class TestSensorAlgo {

    private static final String TAG = TestSensorAlgo.class.getSimpleName();

    private ScreenSize screenSize = new ScreenSize(1920, 1080);

    private int currentZAngle = 15;
    private int currentXAngle = -45;
    private int calibrationZ = 60;
    private int calibrationX = 0;
    private int calibrationDistance = 3;

    private final int maxZOffset = 45;
    private final int maxXOffset = 45;

    public static void main(String[] args){
        TestSensorAlgo testSensorAlgo = new TestSensorAlgo();
        Log.i(TAG, "coordinate:" + testSensorAlgo.calculateCoordinate());
    }

    private Coordinate calculateCoordinate(){
        int x = calculateCoordinateX();
        int y = calculateCoordinateY();
        return new Coordinate(x, y);
    }

    private int calculateCoordinateX(){
        int curZ = currentZAngle;
        if(curZ > calibrationZ){
            curZ -= 360;
        }
        int currZOffset = curZ - calibrationZ;

        int x = screenSize.getWidth() / (maxZOffset * 2) * currZOffset + screenSize.getWidth() / 2;
        if(x < 0) x = 0;
        if(x > screenSize.getWidth()) x = screenSize.getWidth();
        return x;
    }

    private int calculateCoordinateY(){
        int currXOffset = currentXAngle - calibrationX;
        int y = screenSize.getHeight() / (maxXOffset * 2) * currXOffset + screenSize.getHeight() / 2;
        return y;
    }
}
