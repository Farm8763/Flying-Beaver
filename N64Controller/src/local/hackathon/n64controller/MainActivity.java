package local.hackathon.n64controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;

import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;

import android.view.Display;
import android.view.View;
import android.view.MotionEvent;
import android.graphics.*;

interface GamePad
{
	public static final int R_DPAD = 0x00;
	public static final int L_DPAD = 0x01;  
	public static final int D_DPAD = 0x02;
	public static final int U_DPAD = 0x03;
	public static final int START_BUTTON = 0x04;
	public static final int Z_TRIG= 0x05;
    public static final int B_BUTTON = 0x06;
    public static final int A_BUTTON = 0x07;
    public static final int R_CBUTTON = 0x08;
    public static final int L_CBUTTON = 0x09;
    public static final int D_CBUTTON = 0x0A;
    public static final int U_CBUTTON = 0x0B;
    public static final int R_TRIG = 0x0C;
    public static final int L_TRIG = 0x0D;
    public static final int Reserved1 = 0x0E;
    public static final int Reserved2 = 0x0F;  
    public static final int X_AXIS = 0x10;
    public static final int Y_AXIS = 0x11;
    
}

public class MainActivity extends Activity {
	public Controller gameController;
	@SuppressLint("NewApi")
	public void initButtonsDefault(){
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		int distanceFromCenter = 20;
		int defaultRadius = 10;
		
		Point R_DPAD = new Point((int)(width*0.125+distanceFromCenter), (int)(height*0.5));
		Point L_DPAD = new Point((int)(width*0.125-distanceFromCenter), (int)(height*0.5));
		Point D_DPAD = new Point((int)(width*0.125), (int)(height*0.5+distanceFromCenter));
		Point U_DPAD = new Point((int)(width*0.125), (int)(height*0.5-distanceFromCenter));
		
		Point START_BUTTON = new Point((int)(width*0.5), (int)(height*0.5));
		Point Z_TRIG = new Point((int)(width*0.5), (int)(height*0.875));
		Point B_BUTTON = new Point((int)(width*0.75), (int)(height*0.5));
		Point A_BUTTON = new Point((int)(width*0.875), (int)(height*0.625));
		
		Point R_CBUTTON = new Point((int)(width*0.875+distanceFromCenter), (int)(height*0.5));
		Point L_CBUTTON = new Point((int)(width*0.875-distanceFromCenter), (int)(height*0.5));
		Point D_CBUTTON = new Point((int)(width*0.875), (int)(height*0.5+distanceFromCenter));
		Point U_CBUTTON = new Point((int)(width*0.875), (int)(height*0.5-distanceFromCenter));
		
		Point R_TRIG = new Point((int)(width*0.75), (int)(height*0.125));
		Point L_TRIG = new Point((int)(width*0.25), (int)(height*0.125));
		Point joystick = new Point((int)(width*0.5), (int)(height*0.75));

		gameController = new Controller(
				new PushButton(R_DPAD,defaultRadius),
				new PushButton(L_DPAD,defaultRadius),
				new PushButton(D_DPAD,defaultRadius),
				new PushButton(U_DPAD,defaultRadius),
				new PushButton(START_BUTTON,defaultRadius),
				new PushButton(Z_TRIG,defaultRadius),
				new PushButton(B_BUTTON,defaultRadius),
				new PushButton(A_BUTTON,defaultRadius),
				new PushButton(R_CBUTTON,defaultRadius),
				new PushButton(L_CBUTTON,defaultRadius),
				new PushButton(D_CBUTTON,defaultRadius),
				new PushButton(U_CBUTTON,defaultRadius),
				new PushButton(R_TRIG,defaultRadius),
				new PushButton(L_TRIG,defaultRadius),
				null, null, 
				new JoyStick(joystick,defaultRadius));
	}
	
	private UdpConnection udpConnection;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    public void UDPtest(View button) throws UnknownHostException {
    	Log.i("MyActivity", "Jared is a nice person...");
    	
    	InetAddress ip_address = InetAddress.getByName("192.168.1.17");
    	int socket = 6969;
    	Thread t = new Thread(new UdpConnection(ip_address, socket, gameController));
    	t.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	// Detection of a touch on the screen
	@Override
	public boolean onTouchEvent(MotionEvent event){ 
		int index = MotionEventCompat.getActionIndex(event);
		
		Log.i("MyActivity", "Jarred is a nice person...");
		    	
		InetAddress ip_address = null;
		try {
			ip_address = InetAddress.getByName("192.168.1.21");
		} catch (UnknownHostException e) {
			Log.e("MyActivity", "Couldn't make ip address...");
			e.printStackTrace();
		}
		int socket = 6969;
		Thread t = new Thread(new UdpConnection(ip_address, socket));
		t.start();		
		
		int action = MotionEventCompat.getActionMasked(event);
		switch(action) {
		case (MotionEvent.ACTION_DOWN) :
			Log.d("Main","Action was DOWN");
			gameController.update(new Point((int)MotionEventCompat.getX(event, index),(int)MotionEventCompat.getX(event, index)), index);
		return true;
		case (MotionEvent.ACTION_MOVE) :
			Log.d("Main","Action was MOVE");
		return true;
		case (MotionEvent.ACTION_UP) :
			Log.d("Main","Action was UP");
			gameController.liftIndex(index);
		return true;
		case (MotionEvent.ACTION_CANCEL) :
			Log.d("Main","Action was CANCEL");
		return true;
		case (MotionEvent.ACTION_OUTSIDE) :
			Log.d("Main","Movement occurred outside bounds " +
					"of current screen element");
		return true;      
		default : 
			return super.onTouchEvent(event);
		}      
	}
}
