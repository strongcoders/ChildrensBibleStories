package com.childrensbiblestories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity
{
    
    private Button btnSelectStory;
    private Button btnSettings;
    private Button btnAbout;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        // Set this activity into fullscreen...
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_main);
        
        btnSelectStory = (Button) findViewById(R.id.btn_select_story);
        btnSelectStory.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectStoryActivity.class);
                startActivity(intent);
            }
        });
        
        btnSettings = (Button) findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
			}
		});
        
        btnAbout = (Button) findViewById(R.id.btn_about);
        btnAbout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
			}
		});
    }
    
}
