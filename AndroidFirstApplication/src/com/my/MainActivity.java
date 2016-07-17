package com.my;

import com.example.androidfirstapplication.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.method.DialerKeyListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		text1 = (TextView) findViewById(R.id.textView1);
		text2 = (TextView) findViewById(R.id.textView2);
	}
	TextView text1;
	TextView text2;
	
	public void myClick(View view){
		text2.setText( text1.getText().toString());
	}
	public void myClickBtn2(View view){
		Intent intent = new Intent(this, NextActivity.class);
		intent.putExtra("parametr", "Privet!");
		startActivity(intent);
	}
	public void myClickBtnRedirectToAddExample(View view){
		Intent intent = new Intent(this, AddExampleActivity.class);
		startActivity(intent);
	}
	public void myClickBtnRedirectToListExample(View view){
		Intent intent = new Intent(this, ListExampleActivity.class);
		startActivity(intent);
	}	
	public void showDialog(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("Заголовок диалога");
		builder.setMessage("Выберите якусь кнопу");

		builder
		.setCancelable(false)
		.setNegativeButton("Одын вариант", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "clicked ОДЫН вариант", Toast.LENGTH_SHORT).show();
				
			}})
		.setPositiveButton("YESING", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "clicked - YES OF COURSE", Toast.LENGTH_SHORT).show();
				
			}
		})
		.setOnCancelListener(new DialogInterface.OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				Toast.makeText(getApplicationContext(), "Охрана отмена", Toast.LENGTH_SHORT).show();
				
			}
		})
		.setIcon(R.drawable.ic_launcher);

		AlertDialog alert = builder.create();
		alert.show();

	}
	

	@SuppressLint("NewApi")
	public void infoClickExample(View view){
		StringBuilder info = new StringBuilder();
		
        DisplayMetrics metrika = getApplicationContext().getResources().getDisplayMetrics();
        info.append("densityDpi="+metrika.densityDpi);
        info.append(", xdpi="+metrika.xdpi);
        info.append(", ydpi="+metrika.ydpi);
        info.append(", density="+metrika.density);
        info.append(", densityDpi="+metrika.densityDpi);
        info.append(", heightPixels="+metrika.heightPixels);
        info.append(", widthPixels="+metrika.widthPixels);
        info.append(", scaledDensity=" + metrika.scaledDensity + "\n");
        
        info.append("Android OS version: " + Build.VERSION.SDK_INT + "\n"
                + "DEVICE: " + Build.DEVICE + "\n"
                + "DISPLAY: " + Build.DISPLAY + "\n"
                + "PRODUCT: " + Build.PRODUCT + "\n"
                + "MANUFACTURER: " + Build.MANUFACTURER + "\n"
                + "BRAND: " + Build.BRAND + "\n"
                + "MODEL: " + Build.MODEL);

        Configuration config = getApplicationContext().getResources().getConfiguration();
        info.append(",\n CONFIG: screenWidthDp=" + config.screenWidthDp);
        info.append(",\n CONFIG: screenHeightDp=" + config.screenHeightDp);
        info.append(",\n CONFIG: densityDpi=" + config.densityDpi);
        info.append(",\n CONFIG: fontScale=" + config.fontScale);
        
        
        ((TextView) findViewById(R.id.textInfo)).setText(info.toString());

	}
}
