package local.hackathon.n64controller;

import android.graphics.Point;

public class Controller {
	public PushButton rPad;
	public PushButton lPad;
	public PushButton dPad;
	public PushButton uPad;
	public PushButton start;
	public PushButton zTrig;
	public PushButton bBut;
	public PushButton aBut;
	public PushButton rCBut;
	public PushButton lCBut;
	public PushButton dCBut;
	public PushButton uCBut;
	public PushButton rTrig;
	public PushButton lTrig;
	public PushButton res1;
	public PushButton res2;
	public JoyStick joyStick;
	
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
	
	public void update(Point p, int touchIndex) {
		if (rPad.isInside(p)) {
			rPad.push(touchIndex);
		}
		else if (lPad.isInside(p)) {
			lPad.push(touchIndex);
		}
		else if (dPad.isInside(p)) {
			dPad.push(touchIndex);
		}
		else if (uPad.isInside(p)) {
			uPad.push(touchIndex);
		}
		else if (start.isInside(p)) {
			start.push(touchIndex);
		}
		else if (zTrig.isInside(p)) {
			zTrig.push(touchIndex);
		}
		else if (bBut.isInside(p)) {
			bBut.push(touchIndex);
		}
		else if (aBut.isInside(p)) {
			aBut.push(touchIndex);
		}
		else if (rCBut.isInside(p)) {
			rCBut.push(touchIndex);
		}
		else if (lCBut.isInside(p)) {
			lCBut.push(touchIndex);
		}
		else if (dCBut.isInside(p)) {
			dCBut.push(touchIndex);
		}
		else if (uCBut.isInside(p)) {
			uCBut.push(touchIndex);
		}
		else if (rTrig.isInside(p)) {
			rTrig.push(touchIndex);
		}
		else if (lTrig.isInside(p)) {
			lTrig.push(touchIndex);
		}
		else if (res1.isInside(p)) {
			res1.push(touchIndex);
		}
		else if (res2.isInside(p)) {
			res2.push(touchIndex);
		}
		else if (joyStick.isInside(p)) {
			joyStick.setAxes(p, touchIndex);
		}
		else if (joyStick.getIndex()==touchIndex) {
			joyStick.setAxes(p, touchIndex);
		}
	}
	
	public void liftIndex(int index) {
		if (rPad.getIndex()==index) {
			rPad.lift();
		}
		else if (lPad.getIndex()==index) {
			lPad.lift();
		}
		else if (dPad.getIndex()==index) {
			dPad.lift();
		}
		else if (uPad.getIndex()==index) {
			uPad.lift();
		}
		else if (start.getIndex()==index) {
			start.lift();
		}
		else if (zTrig.getIndex()==index) {
			zTrig.lift();
		}
		else if (bBut.getIndex()==index) {
			bBut.lift();
		}
		else if (aBut.getIndex()==index) {
			aBut.lift();
		}
		else if (rCBut.getIndex()==index) {
			rCBut.lift();
		}
		else if (lCBut.getIndex()==index) {
			lCBut.lift();
		}
		else if (dCBut.getIndex()==index) {
			dCBut.lift();
		}
		else if (uCBut.getIndex()==index) {
			uCBut.lift();
		}
		else if (rTrig.getIndex()==index) {
			rTrig.lift();
		}
		else if (lTrig.getIndex()==index) {
			lTrig.lift();
		}
		else if (res1.getIndex()==index) {
			res1.lift();
		}
		else if (res2.getIndex()==index) {
			res2.lift();
		}
		else if (joyStick.getIndex()==index) {
			joyStick.setAxes(new Point(-1,-1), index);
		}
	}
}
