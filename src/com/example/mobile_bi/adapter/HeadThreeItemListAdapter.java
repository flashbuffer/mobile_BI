package com.example.mobile_bi.adapter;

import com.example.mobile_bi.R;
import com.example.mobile_bi.R.id;
import com.example.mobile_bi.R.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HeadThreeItemListAdapter extends BaseAdapter {
	private Context mContext;

	String[] item1 = { " "};
	String[] item2 = { "收入"};
	String[] item3= { "支出"};


	public HeadThreeItemListAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return item1.length;
	}

	@Override
	public Object getItem(int position) {
		return item1[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.three_item_zjrb, parent, false);

		TextView movie = (TextView) view.findViewById(R.id.item_1_3);
		TextView hero = (TextView) view.findViewById(R.id.item_2_3);
		TextView item3 = (TextView) view.findViewById(R.id.item_3_3);

		movie.setText(this.item1[position]);
		hero.setText(this.item2[position]);
		
		item3.setText(this.item3[position]);
		return view;
	}
}