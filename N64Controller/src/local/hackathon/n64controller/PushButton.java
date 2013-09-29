package local.hackathon.n64controller;

import android.graphics.Point;

public class PushButton {
	private byte state;
	private Point location;
	private int radius;
	private int touchIndex;
	
	public PushButton(Point loc, int r) {
		state = 00000000;
		location = loc;
		radius = r;
		touchIndex = -1; //
	}
	
	public boolean isInside(Point p) {
		return (p.x-location.x)*(p.x-location.x) + (p.y-location.y)*(p.y-location.y) <= radius*radius;
	}
	
	public byte getState() {
		return (byte)state;
	}
	
	public void push(int index) {
		state = 00000001;
		touchIndex = index;
	}
	
	public int getIndex() {
		return touchIndex;
	}
	
	public void lift() {
		state = 00000000;
		touchIndex = -1;
	}
	
}
