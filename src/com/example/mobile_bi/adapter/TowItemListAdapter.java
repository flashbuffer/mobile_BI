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

public class TowItemListAdapter extends BaseAdapter {
	private Context mContext;

	String[] item1 = { "期初", "期末"};
	String[] item2 = { "80，000", "100，000"};


	public TowItemListAdapter(Context context) {
		mContext = context;
	}
	


	public TowItemListAdapter(Context context, String[] item1, String[] item2) {
		mContext = context;
		this.item1 = item1;
		this.item2 = item2;
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
		view = inflater.inflate(R.layout.two_item_zjrb, parent, false);

		TextView movie = (TextView) view.findViewById(R.id.item_1_2);
		TextView hero = (TextView) view.findViewById(R.id.item_2_2);

		movie.setText(this.item1[position]);
		hero.setText(this.item2[position]);
		return view;
	}
}