package protocol;

import entity.ScreenSize;
import utils.Config;
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
    public static BasicProtocol createServiceDiscoverResponse(byte errorCode){
        BasicProtocol basicProtocol = new BasicProtocol();
        if(ErrorCode.SUCCESS == errorCode){
            basicProtocol.setErrorCode(ErrorCode.SUCCESS);
            basicProtocol.setMsgId(MsgId.SERVICE_DISCOVER_RESPONSE);
            basicProtocol.setDataFormat(DataFormat.CUSTOM);
            String hostname = Util.getLocalHostname();
            ByteBuffer byteBuffer = ByteBuffer.allocate(4 + hostname.getBytes().length);
            byteBuffer.put(Util.int2ByteArrays(Config.SERVER_LISTEN_PORT));
            byteBuffer.put(hostname.getBytes());
            basicProtocol.setDataArray(byteBuffer.array());
            return basicProtocol;
        }
        return null;
    }


}
