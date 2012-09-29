package com.expancemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper{

	public static final String TABLE_GROUP = "tbl_group";
	private static final String COLUMN_GROUPID = "groupId";
	private static final String COLUMN_GROUPNAME = "groupName";
	private static final String CREATE_GROUPTABLE = "create table "
		      + TABLE_GROUP + "(" + COLUMN_GROUPID
		      + " integer primary key autoincrement, " + COLUMN_GROUPNAME
		      + " text not null);";

	SQLiteDatabase database;
	
	public DatabaseManager(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		database = db;
		database.execSQL(CREATE_GROUPTABLE);
	}
	
	public void insert(String tableName, String id, String name) {
		database.execSQL("INSERT INTO "+tableName+"("+COLUMN_GROUPID+","+COLUMN_GROUPNAME+")"+" VALUES ("+id+","+name+");");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
