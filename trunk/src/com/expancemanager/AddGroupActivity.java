package com.expancemanager;

import android.app.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class AddGroupActivity extends Activity {
	
	ListView memberList ;
	Button addMember;
	private DatabaseManager dbManager;
	Dialog addMember_dialog;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addgroup);
		
		addMember_dialog = new Dialog(AddGroupActivity.this);
		addMember_dialog.setContentView(R.layout.add_member);
		
		dbManager =  new DatabaseManager(AddGroupActivity.this, "cem.db", null, 1);
		dbManager.getWritableDatabase();
		
		memberList = (ListView) findViewById(R.id.list_member);
		addMember = (Button) findViewById(R.id.btn_addmember);
		
		addMember.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				addMember_dialog.show();
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
	}
	
}
