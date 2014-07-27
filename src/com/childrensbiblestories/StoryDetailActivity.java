package com.childrensbiblestories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class StoryDetailActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Set this activity into fullscreen...
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.story_detail);
        
        Intent intent = getIntent();
        String storyName = intent.getExtras().getString("STORY_NAME");
        TextView storyView = (TextView) findViewById(R.id.story);
        
        // This will set the content of story based on the selected item from the story list...
        if (storyName.equalsIgnoreCase("The Story of Christmas")) {
            storyView.setText((CharSequence) getResources().getString(R.string.the_story_of_christmas));
        }
        
        // Make your TextView component scrollable...
        storyView.setMovementMethod(new ScrollingMovementMethod());
    }
    
}
