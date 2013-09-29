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
	private Controller myController;
	
	public UdpConnection(InetAddress new_ip_address, int new_socket, Controller myCont){
		this.ip_address = new_ip_address;
		this.socket = new_socket;
		this.myController = myCont;
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
		message[0] = controllerAddress;
		
		message[1] = myController.rPad.getState() << 0 ||
					 myController.lPad.getState() << 1 ||  
					 myController.dPad.getState() << 2 ||
					 myController.uPad.getState() << 3 ||
					 myController.start.getState() << 4 ||
					 myController.zTrig.getState() << 5 ||
					 myController.bBut.getState() << 6 ||
					 myController.aBut.getState() << 7;
		
		message[2] = myController.rCBut.getState() << 0 ||
					 myController.lCBut.getState() << 1 ||
					 myController.dCBut.getState() << 2 ||
					 myController.uCBut.getState() << 3 ||
					 myController.rTrig.getState() << 4 ||
					 myController.lTrig.getState() << 5 ||
					 myController.res1.getState() << 6 ||
					 myController.res2.getState() << 7;
		
		message[3] = myController.X_AXIS.getXAxis();
		message[4] = myController.Y_AXIS.getYAxis();
		
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
