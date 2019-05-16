package test;

import entity.Coordinate;
import entity.ScreenSize;
import utils.Log;

public class TestSensorAlgo {

    private static final String TAG = TestSensorAlgo.class.getSimpleName();

    private ScreenSize screenSize = new ScreenSize(1920, 1080);

    private int currentZAngle = 70;
    private int currentXAngle = -10;
    private int calibrationZ = 60;
    private int calibrationX = 0;
    private int calibrationDistance = 3;

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
        if(curZ < calibrationZ){
            curZ += 360;
        }
        int offset = (int)(calibrationDistance * Math.tan(curZ - calibrationZ));
        Log.i(TAG, "offset:" + offset);
        int x = screenSize.getWidth() / 2 + offset;
        return x;
    }

    private int calculateCoordinateY(){
        int y = (int)(screenSize.getHeight() / 2 + calibrationDistance * Math.tan(-calibrationX) - calibrationDistance * Math.tan(-currentXAngle));
        return y;
    }
}
