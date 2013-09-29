package local.hackathon.n64controller;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;
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
    
}

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
}
