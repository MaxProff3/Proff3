package com.my;

import com.example.androidfirstapplication.R;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class TestActivity extends Activity{
	DBHelper dbHelper;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_layout);
		dbHelper = new DBHelper(this);
		Log.d("NameTag", "message");
	}

public void onClick(){
	SQLiteDatabase database = dbHelper.getWritableDatabase();
	ContentValues contentValues = new ContentValues();
	/* add */
	contentValues.put(DBHelper.KEY_NAME, "..");
	contentValues.put(DBHelper.KEY_MAIL, "..");
	database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
	/* read */
	Cursor cursor = database.query(DBHelper.TABLE_CONTACTS,null,null,null,null,null,null);
	if(cursor.moveToFirst()){
		int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
		int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
		int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
		
		do{
			Log.i("mLOg","id"+cursor.getInt(idIndex)
				+",name"+cursor.getString(nameIndex)
				+",mail="+cursor.getString(emailIndex));
		}while(cursor.moveToNext());
	
	} else Log.d("mLog","0 rows");
	cursor.close();
	/* clear*/
	database.delete(DBHelper.TABLE_CONTACTS, null, null);
	
	dbHelper.close();
}

}
