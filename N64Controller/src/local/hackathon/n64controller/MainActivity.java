package local.hackathon.n64controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;

import android.view.MenuItem;
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

interface LeftJoystick
{
	public static int x_location = 1;
	public static int y_location = 1;
	public static int radius = 1;
}

interface RightJoystick
{
	public static int x_location = 1;
	public static int y_location = 1;
	public static int radius = 1;
}

public class MainActivity extends Activity {

	private UdpConnection udpConnection;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    
    
    public void UDPtest() throws UnknownHostException {
    	Log.i("MyActivity", "Jared is a nice person...");
    	
    	InetAddress ip_address = InetAddress.getByName("192.168.1.17");
    	int socket = 6969;
    	Thread t = new Thread(new UdpConnection(ip_address, socket));
    	t.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
            	Intent myIntent = new Intent(this, ConfigureActivity.class);
            	finish();
                startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
	// Detection of a touch on the screen
	@Override
	public boolean onTouchEvent(MotionEvent event){ 
		
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
		return true;
		case (MotionEvent.ACTION_MOVE) :
			Log.d("Main","Action was MOVE");
		return true;
		case (MotionEvent.ACTION_UP) :
			Log.d("Main","Action was UP");
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
	
	public boolean isLeftJoystick(MotionEvent event){
		if(inX("Left", event.getX()) && inY("Left", event.getY())){
			return true;
		}
		else{
			return false;	
		}
	}
	
	public boolean isRightJoystick(MotionEvent event){
		if(inX("Right", event.getX()) && inY("Right", event.getY())){
			return true;
		}
		else{
			return false;	
		}
	}
	
	private boolean inX(String string, float x) {
		if(string == "Right"){
			if(x>= RightJoystick.x_location - RightJoystick.radius && x<=RightJoystick.x_location + RightJoystick.radius){
				return true;
			}
			else{
				return false;
			}
		}
		else if(string == "Left"){
			if(x >= LeftJoystick.x_location - LeftJoystick.radius && x <= LeftJoystick.x_location + LeftJoystick.radius){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}

	private boolean inY(String string, float y) {
		if(string == "Right"){
			if(y>= RightJoystick.y_location - RightJoystick.radius && y<=RightJoystick.y_location + RightJoystick.radius){
				return true;
			}
			else{
				return false;
			}
		}
		else if(string == "Left"){
			if(y >= LeftJoystick.y_location - LeftJoystick.radius && y <= LeftJoystick.y_location + LeftJoystick.radius){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}

	public boolean isJoystick(MotionEvent event){
		if(isRightJoystick(event) || isLeftJoystick(event)){
			return true;
		}
		else{
			return false;	
		}
	}
}
