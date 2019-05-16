package protocol;

import entity.ScreenSize;
import utils.Util;

import java.io.File;
import java.nio.ByteBuffer;

public class ProtocolFactory {

    public static BasicProtocol createScreenSizeResponse(){
        BasicProtocol basicProtocol = new BasicProtocol();
        basicProtocol.setMsgId(MsgId.SCREEN_SIZE_RESPONSE);
        ScreenSize screenSize = Util.getScreenSize();
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putInt(screenSize.getWidth());
        buffer.putInt(screenSize.getHeight());
        basicProtocol.setDataArray(buffer.array());
        return basicProtocol;
    }


}
