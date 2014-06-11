package com.example.mobile_bi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
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
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
		
		Log.d(TAG, "icon was clicked.");
	    switch (item.getItemId()) {
	        case R.id.caiwu:
	        	Log.d(TAG, "cai wu icon was clicked.");
	        	Intent intent = new Intent(this, CaiwuActivity.class);
	        	
	        	startActivity(intent);
	            return true;
	        
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
