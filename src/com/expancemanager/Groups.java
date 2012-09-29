package com.expancemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;

public class Groups extends Activity {

	DatabaseManager dbManager;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		dbManager =  new DatabaseManager(getApplicationContext(), "cem.db", null, 1);
		dbManager.getWritableDatabase();
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.activity_groups);
	}
	OnMenuItemClickListener newGroupClickListner = new OnMenuItemClickListener() {

		public boolean onMenuItemClick(MenuItem item) {
			if(item.getTitle().equals("New Group")){
				startActivity(new Intent(getApplicationContext(),AddGroupActivity.class));
			}
			return false;
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_groups, menu);

		MenuItem newGroup = menu.add("New Group");
		newGroup.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		newGroup.setIcon(android.R.drawable.ic_input_add);
		newGroup.setOnMenuItemClickListener(newGroupClickListner);
		
		MenuItem actionItem = menu.add("Action Button");
		actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		actionItem.setIcon(android.R.drawable.ic_menu_share);
		actionItem.setOnMenuItemClickListener(newGroupClickListner);
		
		MenuItem actionItem1 = menu.add("Action Button1");
		actionItem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		actionItem1.setIcon(android.R.drawable.ic_menu_share);
		actionItem1.setOnMenuItemClickListener(newGroupClickListner);

		MenuItem actionItem2 = menu.add("Action Button2");
		actionItem2.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		actionItem2.setIcon(android.R.drawable.ic_menu_share);
		actionItem2.setOnMenuItemClickListener(newGroupClickListner);

		
		return true;
	}
}
