package utils;

import entity.ScreenSize;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class UtilTest {

    private final String TAG = UtilTest.class.getSimpleName();
    @Test
    public void getScreenSize() {
        ScreenSize p = Util.getScreenSize();
        Log.i(TAG, "screen size:" + p.toString());
    }
}