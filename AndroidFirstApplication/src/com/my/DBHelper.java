package com.my;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBHelper extends SQLiteOpenHelper{
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "contactDB";
	public static final String TABLE_CONTACTS = "contacts";
	
	public static final String KEY_ID = "id";
	public static final String KEY_NAME = "name";
	public static final String KEY_MAIL = "mail";
	
	public DBHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	public void onCreate(SQLiteDatabase db){
		db.execSQL("create table " + TABLE_CONTACTS + "(" + KEY_ID
			+ "integer primary key," + KEY_NAME + " text,"+KEY_MAIL + " text"
			+ ")");
	}
	public void onUpgrade(SQLiteDatabase db, int OldVersion, int newVersion){
		db.execSQL("drop table if exists " + TABLE_CONTACTS);
		
		onCreate(db);
	}

}
