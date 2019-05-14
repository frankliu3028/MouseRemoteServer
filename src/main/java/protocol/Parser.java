package protocol;

import utils.Log;
import utils.Util;

import java.awt.*;

public class Parser {

    private static final String TAG = Parser.class.getSimpleName();

    public static Point parseMouseMoveTo(BasicProtocol basicProtocol){
        byte[] data = basicProtocol.getDataArray();
        int x = Util.bytes2Int(data, 0);
        int y = Util.bytes2Int(data, 4);
        Log.i(TAG, "x:" + x + " y:" + y);
        return new Point(x, y);
    }

    public static Point parseMouseMoveRelativeTo(BasicProtocol basicProtocol){
        byte[] data = basicProtocol.getDataArray();
        int x = Util.bytes2Int(data, 0);
        int y = Util.bytes2Int(data, 4);
        Log.i(TAG, "x:" + x + " y:" + y);
        return new Point(x, y);
    }

    public static int parsePressDown(BasicProtocol basicProtocol){
        int button = Util.byteArrayToInt(basicProtocol.getDataArray());
        return button;
    }

    public static int parsePressUp(BasicProtocol basicProtocol){
        int button = Util.byteArrayToInt(basicProtocol.getDataArray());
        return button;
    }

    public static int parseMouseClick(BasicProtocol basicProtocol){
        int button = Util.byteArrayToInt(basicProtocol.getDataArray());
        return button;
    }




}
