package com.my;

import com.example.androidfirstapplication.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddExampleActivity extends Activity{
	private LinearLayout main;
	private Button showMainBtn;
	private Button mainBtn;
	private int countBtns;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_layout);
	
		main = (LinearLayout) findViewById(R.id.add_lay);
		showMainBtn = (Button) findViewById(R.id.showMainButton);
		mainBtn = (Button) findViewById(R.id.mainButton);
		mainBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Button btn = new Button(getApplicationContext());
				btn.setWidth(100);
				btn.setHeight(20);
				btn.setText("нова кнопа " + ++countBtns);
				main.addView(btn);
				
			}
		});
	}

	public void onClickShowBtn(View v) {
			mainBtn.setVisibility(View.VISIBLE);
			
	}	
	
}
