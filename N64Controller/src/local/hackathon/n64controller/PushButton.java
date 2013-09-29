package local.hackathon.n64controller;

import android.graphics.Point;

public class PushButton {
	private Boolean state;
	private Point location;
	private int radius;
	
	public PushButton(Point loc, int r) {
		state = false;
		location = loc;
		radius = r;
	}
	
	public boolean isInside(Point p) {
		return (p.x-location.x)*(p.x-location.x) + (p.y-location.y)*(p.y-location.y) <= radius*radius;
	}
	
	public boolean getState() {
		return state;
	}
	
	
}
