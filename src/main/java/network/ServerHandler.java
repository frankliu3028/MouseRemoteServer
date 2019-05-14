package network;

import entity.MouseControl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import protocol.BasicProtocol;
import protocol.MsgId;
import protocol.Parser;
import utils.Constant;

import java.awt.*;
import java.awt.event.InputEvent;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    private final String TAG = ServerHandler.class.getSimpleName();
    private MouseControl mouseControl;

    public ServerHandler(){
        mouseControl = new MouseControl();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        BasicProtocol basicProtocol = (BasicProtocol) msg;
        switch (basicProtocol.getMsgId()){
            case MsgId.MOVE_TO:
                Point moveTo = Parser.parseMouseMoveTo(basicProtocol);
                mouseControl.moveTo(moveTo.x, moveTo.y);
                break;
            case MsgId.MOVE_RELATIVE:
                Point moveRelativeTo = Parser.parseMouseMoveRelativeTo(basicProtocol);
                mouseControl.moveRelativeTo(moveRelativeTo.x, moveRelativeTo.y);
                break;
            case MsgId.PRESS_DOWN:
                int buttonPressDown = getButtonMask(Parser.parsePressDown(basicProtocol));
                mouseControl.pressDown(buttonPressDown);
                break;
            case MsgId.PRESS_UP:
                int buttonPressUp = getButtonMask(Parser.parsePressUp(basicProtocol));
                mouseControl.pressUp(buttonPressUp);
                break;
            case MsgId.MOUSE_CLICK:
                int buttonClick = getButtonMask(Parser.parseMouseClick(basicProtocol));
                mouseControl.mouseClick(buttonClick);
                break;
                default:
                    break;
        }
    }

    private int getButtonMask(int button){
        int res = -1;
        if(button == Constant.BUTTON_LEFT) res = InputEvent.BUTTON1_MASK;
        if(button == Constant.BUTTON_RIGHT) res = InputEvent.BUTTON2_MASK;
        return res;
    }
}
