package test;

import java.net.*;

public class Test {
	
	public static ApiTester tester;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		tester = new ApiTester();
		byte[] data = new byte[2];
		data[0] = 0;
		data[1] = 106;
		try {
			DatagramPacket packet = new DatagramPacket(data,data.length,InetAddress.getByName("127.0.0.1"),10106);
			tester.testApi(packet, new TesterCallback() {

				@Override
				public void receiveData(DatagramPacket packet) {
					// TODO Auto-generated method stub
					byte[] data = packet.getData();
					System.out.println("receiveData:"+data);
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

}
