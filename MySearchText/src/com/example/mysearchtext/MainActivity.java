package com.example.mysearchtext;

import java.util.ArrayList;

import com.example.mysearchtext.MyAdapter;
import com.example.mysearchtext.R;
import com.example.mysearchtext.Student;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {

	EditText txtSearch;
	ListView lv;
	MyAdapter myadapter;
	
	ArrayList <String> list = new ArrayList<String>();
	ArrayList<Student> lists = new ArrayList<Student>();
	ArrayList <String> source = new ArrayList<String>();
    ArrayAdapter <String> adapter;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtSearch=(EditText) this.findViewById(R.id.editText1);
        this.lv=(ListView) this.findViewById(R.id.listView1);
        this.adapter = new ArrayAdapter <String> (this,android.R.layout.simple_list_item_1,list);
        this.lv.setAdapter(adapter);
        
        lists.add(new Student(R.drawable.img1,"Alpha, Bravo","BSIT"));
        lists.add(new Student(R.drawable.img2,"Charlie, Hotel","BSOA"));
        lists.add(new Student(R.drawable.img3,"Mike, India","BSCREAM"));
        lists.add(new Student(R.drawable.img4,"November, Kilo","BSHRM"));
        lists.add(new Student(R.drawable.img5,"Oscar, Quebec","BSE"));
        lists.add(new Student(R.drawable.img6,"Zulu, Uniform","AB"));
        lists.add(new Student(R.drawable.img7,"Delta, Tango","BSA"));
        lists.add(new Student(R.drawable.img8,"Juliet, Sierra","BSBA"));
        
        myadapter = new MyAdapter(this,lists);
        this.lv.setAdapter(myadapter);
        
        this.lv.setOnItemClickListener( this);
    }
	@Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setTitle(lists.get(arg2).getStudentName());
			
			ImageView myiv=new ImageView(this);
				myiv.setImageResource(lists.get(arg2).getImage());
			TextView myname=new TextView(this);
				myname.setText(lists.get(arg2).getStudentName());
			TextView mycourse=new TextView(this);
				mycourse.setText(lists.get(arg2).getCourse());
			
			LinearLayout mainLayout=new LinearLayout(this);	
					mainLayout.setOrientation(LinearLayout.HORIZONTAL);
					mainLayout.addView(myiv);
					
			LinearLayout subLayout=new LinearLayout(this);
				subLayout.setOrientation(LinearLayout.VERTICAL);
				subLayout.addView(myname);
				subLayout.addView(mycourse);
				
				mainLayout.addView(subLayout);
				
				builder.setView(mainLayout);
				builder.setNeutralButton("Okey", null);
				
		AlertDialog dialog=builder.create();
			dialog.show();
		
				
	}
    
}
