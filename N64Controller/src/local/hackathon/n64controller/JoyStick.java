package local.hackathon.n64controller;

import android.graphics.Point;

public class JoyStick {
	private Point location;
	private int radius;
	private byte x_axis;
	private byte y_axis;
	private int touchIndex;
	
	public void setAxes(Point p, int index) {
		if ((p.x-location.x)*(p.x-location.x) + (p.y-location.y)*(p.y-location.y) <= radius*radius) {
			x_axis = (byte)(p.x-location.x + radius);
			y_axis = (byte)(p.y-location.y + radius);
			touchIndex = index;
		}
		else {
			x_axis = (byte)(0);
			y_axis = (byte)(0);
			touchIndex = -1;
		}
	}
	
	public byte getXAxis() {
		return x_axis;
	}
	
	public byte getYAxis() {
		return y_axis;
	}
	
	public int getIndex() {
		return touchIndex;
	}
	
	public boolean isInside(Point p) {
		return (p.x-location.x)*(p.x-location.x) + (p.y-location.y)*(p.y-location.y) <= radius*radius;
	}
	
}
