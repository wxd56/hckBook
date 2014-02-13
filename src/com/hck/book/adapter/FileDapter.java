package com.hck.book.adapter;

import java.util.ArrayList;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hck.test.R;

public class FileDapter extends BaseAdapter{
private Context context;
public static ArrayList<Map<String, Object>> aList;
GetView getView;
private int a;
public FileDapter(Context context,ArrayList<Map<String, Object>> aList,int a)
{
	this.context=context;
	FileDapter.aList=aList;
	this.a=a;
}
	@Override
	public int getCount() {
		return aList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return aList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}
	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		View view=arg1;
		if (view==null) {
			view=LayoutInflater.from(context).inflate(R.layout.item_import, null);
			getView=new GetView();
			getView.imageView=(ImageView) view.findViewById(R.id.im);
			getView.textView=(TextView) view.findViewById(R.id.name2);
			getView.textView2=(TextView) view.findViewById(R.id.num2);
			getView.imageView2=(ImageView) view.findViewById(R.id.imChoose);
			getView.textView3=  (TextView) view.findViewById(R.id.imChoose2);
			getView.textView4=(TextView) view.findViewById(R.id.num1);
			getView.textView5=(TextView) view.findViewById(R.id.name1);
			view.setTag(getView);
		}
		else {
			getView=(GetView) view.getTag();
		}
		Map<String, Object>  map = aList.get(position);
		String icon=map.get("icon").toString();
		getView.imageView.setImageResource(Integer.parseInt(icon));
		
		getView.textView.setText(map.get("name").toString());
		if (map.get("num")!=null) {
			getView.textView2.setText(map.get("num").toString());
		}
		if (map.get("imChoose")!=null) {
			String string1=map.get("imChoose").toString();
			getView.imageView2.setImageResource(Integer.parseInt(string1));
		}
		if (map.get("imChoosezz")!=null) {
			getView.textView3.setText(map.get("imChoosezz").toString());
		}
		
		if (position==0 && a==2) {
			getView.textView.setVisibility(View.GONE);
			getView.textView5.setVisibility(View.INVISIBLE);
			getView.textView2.setVisibility(View.INVISIBLE);
			getView.textView4.setVisibility(View.INVISIBLE);
		}
		return view;
	}
  static class GetView
  {
	  ImageView imageView,imageView2,imageView3;
	  TextView textView,textView2,textView3,textView4,textView5;
  }
	
}
