package com.pjt.contentprovider.demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper{

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table person(" +
				"_id integer primary key autoincrement, " +
				" name text not null," +
				" age integer not null," +
				" height real not null" +
				")");
		db.execSQL("insert into person(name,age,height)" +
				"  values('ÕÅÈý',23,1.82)");
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion ) {
		db.execSQL("drop table person");
		onCreate(db);
		
	}
	
	

}
