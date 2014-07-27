package com.childrensbiblestories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SelectStoryActivity extends Activity {

    private Button btnOldTestament;
    private Button btnNewTestament;
    private static final String LIST_OF_STORIES = "LIST_OF_STORIES";
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Set this activity into fullscreen...
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.select_story);
        
        btnOldTestament = (Button) findViewById(R.id.btn_old_testament);
        btnOldTestament.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SelectStoryActivity.this, StoryTestamentListActivity.class);
                String[] listOfStories = getResources().getStringArray(R.array.old_testament_list);
                
                intent.putExtra(LIST_OF_STORIES, listOfStories);
                startActivity(intent);
            }
        });
        
        btnNewTestament = (Button) findViewById(R.id.btn_new_testament);
        btnNewTestament.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SelectStoryActivity.this, StoryTestamentListActivity.class);
                String[] listOfStories = getResources().getStringArray(R.array.new_testament_list);
                
                intent.putExtra(LIST_OF_STORIES, listOfStories);
                startActivity(intent);
            }
        });
        
    }
    
}
