package local.hackathon.n64controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ConfigureActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configure);
		
	}
	
	public void SaveConfig(View button) throws UnknownHostException {
    	/*
		Log.i("MyActivity", "Jared is a nice person...");
    	UdpConnection udpConnection;
    	
    	EditText editText = (EditText)findViewById(R.id.ipTextbox);
    	String ip_address = editText.getText().toString();
    	editText = (EditText)findViewById(R.id.portTextbox);
    	int socket = editText.getText().toString();
    	
    	
    	udpConnection.setIpAddress(InetAddress.getByName(ip_address));
    	udpConnection.setIpAddress(InetAddress.getByName(socket));
    	udpConnection.setDataSocket(dataSocket);
    	*/
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.configure, menu);
		return true;
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
            	Intent myIntent = new Intent(this, MainActivity.class);
            	finish();
                startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    

}
