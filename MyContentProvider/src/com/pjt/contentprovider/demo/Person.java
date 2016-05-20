package com.pjt.contentprovider.demo;

import android.net.Uri;

public class Person {
	
	/**
	 * 1.URI路径
	 * 2.静态常量提供表的列名
	 */
	//查找ContentProvider数据源的固定路径
		//多条记录
		public static final String MIME_DIR_PREFIX = "vnd.android.cursor.dir";
		//单条记录
		public static final String MIME_ITEM_PREFIX = "vnd.android.cursor.item";
		public static final String MINE_ITEM = "vnd.pjt.person";
		
		
		public static final String MINE_TYPE_SINGLE = 
		MIME_ITEM_PREFIX + "/" + MINE_ITEM;
		
		public static final String MINE_TYPE_MULTIPLE = 
		MIME_DIR_PREFIX + "/" + MINE_ITEM;
		
		public static final String AUTHORITY = "com.pjt.personprovider.demo";
		public static final String PATH_SINGLE = "person/#";
		public static final String PATH_MULTIPLE = "person";
		
		public static final String CONTENT_URI_STRING = 
		"content://" + AUTHORITY + "/" + PATH_MULTIPLE;
		
		public static final Uri  CONTENT_URI = 
		Uri.parse(CONTENT_URI_STRING); 
		
		
	
	public static final String KEY_NAME="name";
	public static final String KEY_ID="_id";
	public static final String KEY_AGE="age";
    public static final String KEY_HEIGHT="height";
    
    
}
