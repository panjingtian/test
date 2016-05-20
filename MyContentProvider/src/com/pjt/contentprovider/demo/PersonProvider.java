package com.pjt.contentprovider.demo;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonProvider extends ContentProvider {

    
	SQLiteDatabase db = null;

	static  UriMatcher urimatcher=null;
	
	static {
		urimatcher = new UriMatcher(UriMatcher.NO_MATCH);
		// ע������URI·��
		urimatcher.addURI(Person.AUTHORITY, Person.PATH_SINGLE, 1);
		urimatcher.addURI(Person.AUTHORITY, Person.PATH_MULTIPLE, 2);

	}

	@Override
	public int delete(Uri uri, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		switch (urimatcher.match(uri)) {
		case 1:

			return Person.MINE_TYPE_SINGLE;

		case 2:
			return Person.MINE_TYPE_MULTIPLE;

		default:
			throw 
			new IllegalArgumentException
			("������URI·����ʽ����:"+uri);
		}
		

	}

	@Override
	public Uri insert(Uri uri, ContentValues cv) {
		Uri newUri = null;
		long rowid = db.insert("person", null, cv);

		if (rowid > 0) {

			newUri = ContentUris.withAppendedId(Person.CONTENT_URI, rowid);
			// ֪ͨ����ˢ�����ݣ�֪ͨ������
			getContext().getContentResolver().notifyChange(newUri, null);

			
		} else {

			throw new SQLException("Failed to insert row into " + uri);
		}
		return newUri;

	}

	/**
	 * ���÷���ֵȷ���Ƿ񴴽����ݿ�ɹ�
	 */
	@Override
	public boolean onCreate() {
		// ��׿ϵͳʵ����Personprovider��ͬʱ������ݿⴴ�������ݽ���
		Context c = super.getContext();
		DBHelper dbhelper = new DBHelper(c, "person.db", null, 1);
		db = dbhelper.getWritableDatabase();
		if (db == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
			String arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
