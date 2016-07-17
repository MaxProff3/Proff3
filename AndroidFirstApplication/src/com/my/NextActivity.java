package com.my;

import com.example.androidfirstapplication.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class NextActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next_layout);		
		
		Intent intent = getIntent();
		String par = intent.getStringExtra("parametr");
		
		Toast.makeText(this, par, Toast.LENGTH_SHORT).show();
	}	
	
}
