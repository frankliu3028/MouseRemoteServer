package main;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;

public class Listener extends Thread{
	
	public static boolean RUN = true;
	
	private DatagramSocket socket;
	private MouseControl mc;
	
	public Listener() {
		mc = new MouseControl();
		try {
			socket = new DatagramSocket(10106,InetAddress.getByName("127.0.0.1"));
		}catch(Exception e) {
			e.printStackTrace();
			RUN = false;
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(RUN) {
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
			try {
				socket.receive(packet);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public void handlePacket(DatagramPacket packet) {
		byte[] data = packet.getData();
		switch(data[0]) {
		case 0:
			System.out.println("receive 0");
			if(data[1]!=106)break;
			byte[] b = new byte[1];
			b[0] = 106;
			DatagramPacket ret = new DatagramPacket(b,b.length,packet.getAddress(),packet.getPort());
			try {
				socket.send(ret);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			break;
		case 1:
			int x = Util.bytes2Int(data, 1);
			int y = Util.bytes2Int(data, 5);
			mc.moveRelativeTo(x, y);
			break;
		case 2:
			mc.click();
			break;
			default:
				break;
		}
	}

	
	
}
