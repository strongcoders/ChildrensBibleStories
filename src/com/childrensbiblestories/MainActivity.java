package com.childrensbiblestories;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity
{
    
    private Button btnSelectStory;
    private Button btnStoryQuiz;
    private Button btnAbout;
    private CheckBox cbPlayAudio;
    
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
        
        btnStoryQuiz = (Button) findViewById(R.id.btn_story_quiz);
        btnStoryQuiz.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, QuizDetailActivity.class);
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
        
        // Initialize the shared preference object...
        SharedPreferences sharedPref = getSharedPreferences("AudioPlay", Context.MODE_PRIVATE);
        
        cbPlayAudio = (CheckBox) findViewById(R.id.cb_play_audio);
        // Get the status of the checkbox (Whether it is checked or not)
        cbPlayAudio.setChecked(sharedPref.getBoolean("is_audio_play", false));
        cbPlayAudio.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences sharedPref = v.getContext().getSharedPreferences("AudioPlay", Context.MODE_PRIVATE);
				Editor editor = sharedPref.edit();
				
				if (cbPlayAudio.isChecked()) {
					editor.putBoolean("is_audio_play", true);
				} else {
					editor.putBoolean("is_audio_play", false);
				}
				
				editor.commit();
			}
        	
        });
    }
    
    @Override
    public void onBackPressed() {
    	AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
    	exitDialog.setMessage("Are you sure you want to exit?");
    	exitDialog.setCancelable(false);
    	
    	exitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				MainActivity.super.onBackPressed();
			}
		});
    	
    	exitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// Do nothing here...
			}
		});
    	
    	exitDialog.create().show();
    }
}
