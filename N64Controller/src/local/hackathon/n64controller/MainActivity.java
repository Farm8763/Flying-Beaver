package local.hackathon.n64controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.graphics.*;
//blah
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
   
    
}
