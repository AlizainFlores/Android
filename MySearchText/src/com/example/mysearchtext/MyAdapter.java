package com.example.mysearchtext;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	Context context;
	ArrayList <Student> lists;
	LayoutInflater inflater;
 
	public MyAdapter(Context context, ArrayList<Student> lists) {
		super();
		this.context = context;
		this.lists = lists;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return lists.size();
	}

	@Override
	public Object getItem(int arg0) {
		return lists.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		StudentHandler handler =null;
		if(arg1==null)
		{
			arg1 =inflater.inflate(R.layout.itemlayout, null);
			handler = new StudentHandler();
			handler.iv=(ImageView) arg1.findViewById(R.id.imageView1);
			handler.name = (TextView) arg1.findViewById(R.id.textView1);
			handler.course = (TextView) arg1.findViewById(R.id.textView2);	
			arg1.setTag(handler);
		}
		else handler = (StudentHandler) arg1.getTag();
		
		handler.iv.setImageResource(lists.get(arg0).getImage());
		handler.name.setText(lists.get(arg0).getStudentName());
		handler.course.setText(lists.get(arg0).getCourse());
				
		return arg1;
	}
	
	static class StudentHandler{
		ImageView iv;
		TextView name;
		TextView course;
		
	}

}