package local.hackathon.n64controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;

import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;

import android.view.View;
import android.view.MotionEvent;
import android.graphics.*;


interface GamePad
{
    public static final int a = 1;
    public static final int c_down = 2;
    public static final int c_right = 3;
    public static final int b = 4;
    public static final int c_left = 5;
    public static final int c_up = 6;
    public static final int l_bumper = 7;
    public static final int r_bumper = 8;
    public static final int start = 9;
    public static final int z = 10;
    public static final int up_arrow = 11;
    public static final int down_arrow = 12;
    public static final int left_arrow = 13;
    public static final int right_arrow = 14;
    public static final int  x_left = 15;
    public static final int x_right = 16;
    public static final int  y_up = 17;
    public static final int y_down = 18;
    public static final int left_joystick = 19;
    public static final int right_joystick = 20;
}
interface LeftJoystick
{
	public static final int x_location_start = 1;
	public static final int x_location_end = 1;
	public static final int y_location_start = 1;
	public static final int y_location_end = 1;
}

interface RightJoystick
{
	public static final int x_location_start = 1;
	public static final int x_location_end = 1;
	public static final int y_location_start = 1;
	public static final int y_location_end = 1;
}

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void UDPtest(View button) throws UnknownHostException {
    	Log.i("MyActivity", "Jared is a nice person...");
    	
    	InetAddress ip_address = InetAddress.getByName("192.168.1.17");
    	int socket = 6969;
    	Thread t = new Thread(new UdpConnection(ip_address, socket));
    	t.start();
    }
    
    //Jared sucks.


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	// Detection of a touch on the screen
	@Override
	public boolean onTouchEvent(MotionEvent event){ 

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
			if(x>= RightJoystick.x_location_start && x<=RightJoystick.x_location_end){
				return true;
			}
			else{
				return false;
			}
		}
		else if(string == "Left"){
			if(x >= LeftJoystick.x_location_start && x <= LeftJoystick.x_location_end){
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
			if(y>= RightJoystick.y_location_start && y<=RightJoystick.y_location_end){
				return true;
			}
			else{
				return false;
			}
		}
		else if(string == "Left"){
			if(y >= LeftJoystick.y_location_start && y <= LeftJoystick.y_location_end){
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
