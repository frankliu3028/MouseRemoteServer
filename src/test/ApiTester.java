package test;

import java.net.*;

public class ApiTester {
	
	private TesterCallback callback;
	private DatagramSocket socket;
	
	public ApiTester() {
		try {
			socket = new DatagramSocket();
			socket.setSoTimeout(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ApiTester(TesterCallback callback) {
		this.callback = callback;
		try {
			socket = new DatagramSocket();
			socket.setSoTimeout(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testApi(DatagramPacket packet) {
		try {
			socket.send(packet);
			byte[] buffer = new byte[1024];
			DatagramPacket recPacket = new DatagramPacket(buffer,buffer.length);
			socket.receive(recPacket);
			callback.receiveData(recPacket);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testApi(DatagramPacket packet, TesterCallback callback) {
		try {
			socket.send(packet);
			byte[] buffer = new byte[1024];
			DatagramPacket recPacket = new DatagramPacket(buffer,buffer.length);
			socket.receive(recPacket);
			callback.receiveData(recPacket);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
