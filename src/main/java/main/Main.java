package main;


import network.Server;

import sd.SDServer;
import sd.SDServerCallback;
import utils.Config;
import utils.Log;

public class Main {
	public static final String TAG = Main.class.getSimpleName();

	public static Server server;
	public static SDServer sdServer;
	public static SDServerCallback callback = new SDServerCallback() {
		@Override
		public void serviceStartResults(int errorCode) {
			Log.i(TAG, "errorCode:" + errorCode);
		}
	};
	public static void main(String[] args) {
		sdServer = new SDServer(callback);
		sdServer.start();
		server = new Server(Config.SERVER_LISTEN_PORT);
		server.start();
	}
	
	

}
