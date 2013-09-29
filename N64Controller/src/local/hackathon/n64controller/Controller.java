package local.hackathon.n64controller;

import android.graphics.Point;

public class Controller {
	private PushButton rPad;
	private PushButton lPad;
	private PushButton dPad;
	private PushButton uPad;
	private PushButton start;
	private PushButton zTrig;
	private PushButton bBut;
	private PushButton aBut;
	private PushButton rCBut;
	private PushButton lCBut;
	private PushButton dCBut;
	private PushButton uCBut;
	private PushButton rTrig;
	private PushButton lTrig;
	private PushButton res1;
	private PushButton res2;
	private JoyStick joyStick;
	
	public Controller(PushButton rP,
			PushButton lP,
			PushButton dP,
			PushButton uP,
			PushButton st,
			PushButton zT,
			PushButton bB,
			PushButton aB,
			PushButton rC,
			PushButton lC,
			PushButton dC,
			PushButton uC,
			PushButton rT,
			PushButton lT,
			PushButton r1,
			PushButton r2,
			JoyStick jStick) {
		rPad = rP;
		lPad = lP;
		dPad = dP;
		uPad = uP;
		start = st;
		zTrig = zT;
		bBut = bB;
		aBut = aB;
		rCBut = rC;
		lCBut = lC;
		dCBut = dC;
		uCBut = uC;
		rTrig = rT;
		lTrig = lT;
		res1 = r1;
		res2 = r2;
		joyStick = jStick;
	}
	
	public void update(Point p) {
		if (rPad.isInside(p)) {
			
		}
		else if (lPad.isInside(p)) {
			
		}
		else if (dPad.isInside(p)) {
			
		}
		else if (uPad.isInside(p)) {
			
		}
		else if (start.isInside(p)) {
			
		}
		else if (zTrig.isInside(p)) {
			
		}
		else if (bBut.isInside(p)) {
			
		}
		else if (aBut.isInside(p)) {
			
		}
		else if (rCBut.isInside(p)) {
			
		}
		else if (lCBut.isInside(p)) {
			
		}
		else if (dCBut.isInside(p)) {
			
		}
		else if (uCBut.isInside(p)) {
			
		}
		else if (rTrig.isInside(p)) {
			
		}
		else if (lTrig.isInside(p)) {
			
		}
		else if (res1.isInside(p)) {
			
		}
		else if (res2.isInside(p)) {
			
		}
		else {
			joyStick.setAxes(p);
		}
	}
}
