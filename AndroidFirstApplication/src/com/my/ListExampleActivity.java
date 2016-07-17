package com.my;

import java.util.ArrayList;
import java.util.List;

import com.example.androidfirstapplication.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class ListExampleActivity extends Activity{
	private ListView listView;
	private List<String> list = new ArrayList<>();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);		
		
		listView = (ListView) findViewById(R.id.listView1);
		//
		for(int i=1; i<100; i++){
			list.add("номер "+i);
		}
		//
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
		
		listView.setAdapter(adapter);
	}	
	
}