package com.childrensbiblestories;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;

public class SettingsActivity extends Activity {

	private CheckBox cbPlayAudio;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
    	
    	// Set this activity into fullscreen...
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_settings);
        
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
	
}
