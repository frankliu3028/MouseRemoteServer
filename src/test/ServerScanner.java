package test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerScanner {


    public ServerScanner(){
    }

    public InetSocketAddress scan(){
        String ip= getMyAddr();
        final String front=ip.substring(0,ip.lastIndexOf(".")+1);

        try{

            DatagramSocket socket=new DatagramSocket();
            byte[] msgb=new byte[2];
            msgb[0] = 0;
            msgb[1] = 105;
            for(int i=0;i<256;++i){
                try{
                    InetAddress targetIp=InetAddress.getByName(front+i);
                    DatagramPacket packet=new DatagramPacket(msgb,msgb.length,targetIp,10106);
                    socket.send(packet);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            byte[] buffer=new byte[1024];
            DatagramPacket rPacket=new DatagramPacket(buffer,buffer.length);
            socket.setSoTimeout(3000);
            socket.receive(rPacket);
            String msg=new String(rPacket.getData(),0,rPacket.getLength());
            int port=Integer.parseInt(msg);
            InetSocketAddress res=new InetSocketAddress(rPacket.getAddress(),port);
            return res;
        }catch(SocketTimeoutException e){
            e.printStackTrace();
        }catch(SocketException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;

    }
    
    public String getMyAddr() {
    	Socket socket = new Socket();
    	try {
    	    //设置主机为www.baidu.com，端口为80
    	    SocketAddress addr = new InetSocketAddress("www.baidu.com", 80);
    	    //打开连接，超时时间为1秒
    	    socket.connect(addr, 1000);
    	    //通过socket获取本机ip地址
    	    String res=socket.getLocalAddress().getHostAddress();
    	    System.out.println("ip is:"+res);
    	    return res;
    	}catch (Exception e) {
    		e.printStackTrace();
    	}finally {
    	    try {
    	        socket.close();
    	    } catch (Throwable e) {
    	    	
    	    }
    	}
    	return null;
    }

}