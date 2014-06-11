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

public class SzmxActivity extends Activity {
	ThreeItemListAdapter threeItemListAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account_and_summary);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account_and_summary, menu);
		
		ListView listView = (ListView) findViewById(R.id.listview_acc_sum_jy);
		
		String[] item1 = { "期初", "期末"};
		String[] item2 = { "20，000", "30，000"};
		listView.setAdapter(new TowItemListAdapter(this,item1,item2));
		
		listView = (ListView) findViewById(R.id.listview_acc_sum_head);
		listView.setAdapter(new HeadThreeItemListAdapter(this));
		
		
		listView = (ListView) findViewById(R.id.listview_acc_sum_detial);
		String[] item13 = {  "购买", "存入","付款","付款","付款","付款","付款","付款"};
		String[] item23 = {  "20", "10" , "20", "10", "20", "10", "20", "10" };
		String[] item33=  {  "10", "10",  "20", "10", "20", "10", "20", "10"};
		String[] rowTag=  {  "购买办公电脑和桌椅", "存入现金",  "付款给赵某某", "付款王某某", "付款王某某和陈某某", "付款王某某，陈某某和万事达有限公司", "付款王某某，陈某某和万事达有限公司", "付款王某某，陈某某和万事达有限公司"};
		
		threeItemListAdapter = new ThreeItemListAdapter(this,item13,item23,item33,rowTag);
		
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
		
		return true;
	}

}
