package main;


import network.Server;
import utils.Config;

public class Main {
	public static final String TAG = Main.class.getSimpleName();

	public static Server server;
	public static void main(String[] args) {
		server = new Server(Config.SERVER_LISTEN_PORT);
		server.start();
	}
	
	

}
