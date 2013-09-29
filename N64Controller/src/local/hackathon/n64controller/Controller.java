package local.hackathon.n64controller;

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
		
	}
}
