package test;

import java.awt.HeadlessException;
import java.awt.MouseInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.*;

import main.Util;

public class Test {
	
	public static ApiTester tester;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		tester = new ApiTester();
		
		try {
			DatagramPacket packet = getPacket();
			tester.testApi(packet, new TesterCallback() {

				@Override
				public void receiveData(DatagramPacket packet) {
					// TODO Auto-generated method stub
					byte[] data = packet.getData();
					System.out.println("receiveData:"+data[0]+","+data[1]);
				}
				
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
//		ServerScanner sc = new ServerScanner();
//		InetSocketAddress serverAddr = sc.scan();
//		
//		String ip = serverAddr.getAddress().getHostAddress();
//		int port = serverAddr.getPort();
//		System.out.println("ip:"+ip);
//		System.out.println("port:"+port);
		
		
	}
	
	public static DatagramPacket getPacket() throws HeadlessException, IOException {
		byte[] data;
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;
		System.out.println("send x:"+x);
		System.out.println("send y:"+y);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(1);
		bos.write(Util.int2ByteArrays(x));
		bos.write(Util.int2ByteArrays(y));
		data = bos.toByteArray();
		DatagramPacket packet = new DatagramPacket(data,data.length,InetAddress.getByName("127.0.0.1"),10106);
		return packet;
	}

}
