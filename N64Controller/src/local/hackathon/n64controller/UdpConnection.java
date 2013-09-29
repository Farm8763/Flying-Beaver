package local.hackathon.n64controller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import android.util.Log;


public class UdpConnection implements Runnable{
	
	private DatagramSocket dataSocket = null;
	private InetAddress ip_address = null;
	private int socket = -1;
	
	public UdpConnection(InetAddress new_ip_address, int new_socket){
		this.ip_address = new_ip_address;
		this.socket = new_socket;
	}

	public DatagramSocket getDataSocket() {
		return dataSocket;
	}
	public void setDataSocket(DatagramSocket dataSocket) {
		this.dataSocket = dataSocket;
	}
	public InetAddress getIpAddress() {
		return ip_address;
	}
	public void setIpAddress(InetAddress address) {
		this.ip_address = address;
	}
	public int getSocket() {
		return socket;
	}
	public void setSocket(int new_socket) {
		this.socket = new_socket;
	}

	public void run(){
		Log.i("MyActivity", "Starting UDP Run");
		
		//temp settings
		//try {
		//	setIpAddress(InetAddress.getByName("192.168.1.17"));
		//	setSocket(6969);
		//} catch (UnknownHostException e1) {
		//	Log.e("MyActivity", "Unable to set temp settings for connection");
		//	e1.printStackTrace();
		//}
		
		if((this.socket != 1)&&(this.ip_address != null)){
			try {
				setDataSocket(new DatagramSocket());
			} catch (SocketException e) {
				Log.e("MyActivity", "Unable to generate DatagramSocket");
				e.printStackTrace();
			}
		}
		
		String messageStr="Hello Charles!";
		int msg_length=messageStr.length();
		byte[] message = new byte[5];
		message[0] = myController.number;
		
		message[1] = myController.rPad 	<< 0 ||
					 myController.lPad 	<< 1 ||  
					 myController.dPad 	<< 2 ||
					 myController.uPad 	<< 3 ||
					 myController.start	<< 4 ||
					 myController.zTrig << 5 ||
					 myController.bBut 	<< 6 ||
					 myController.aBut 	<< 7;
		
		message[2] = myController.rCBut << 0 ||
					 myController.lCBut << 1 ||
					 myController.dCBut << 2 ||
					 myController.uCBut << 3 ||
					 myController.rTrig << 4 ||
					 myController.lTrig << 5 ||
					 myController.res1 	<< 6 ||
					 myController.res2 	<< 7;
		
		message[3] = myController.X_AXIS;
		message[4] = myController.Y_AXIS;
		
		DatagramPacket p = new DatagramPacket(message, msg_length, ip_address, socket);
		
		
		while(true){
			Log.i("MyActivity", "Sending message...");
			try {
				Thread.sleep(5000);
				dataSocket.send(p);
			} catch (IOException e) {
				Log.e("MyActivity", "Unable to send message");
				e.printStackTrace();
			} catch (InterruptedException e) {
				Log.e("MyActivity", "Thread sleep error");
				e.printStackTrace();
			}
		}
	}
}
