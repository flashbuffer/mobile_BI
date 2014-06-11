package com.example.mobile_bi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobile_bi.adapter.HeadThreeItemListAdapter;
import com.example.mobile_bi.adapter.ThreeItemListAdapter;
import com.example.mobile_bi.adapter.TowItemListAdapter;

public class ZjrbActivity extends Activity {
	ThreeItemListAdapter threeItemListAdapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zjrb);
		
		ListView listView = (ListView) findViewById(R.id.listview_zjrb);
		listView.setAdapter(new TowItemListAdapter(this));
		
		listView = (ListView) findViewById(R.id.listview_zjrb_head);
		listView.setAdapter(new HeadThreeItemListAdapter(this));
		
		
		listView = (ListView) findViewById(R.id.listview_zjrb_detial);
		
		threeItemListAdapter = new ThreeItemListAdapter(this);
		listView.setAdapter(threeItemListAdapter);
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view,
			    int position, long id) {
			    Toast.makeText(getApplicationContext(),
			      threeItemListAdapter.rowTag[position], Toast.LENGTH_LONG)
			      .show();
			  }
			}); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zjrb, menu);
		return true;
	}
	


}
