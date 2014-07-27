package com.childrensbiblestories;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class StoryTestamentListActivity extends ListActivity {
    
    private static final String STORY_NAME = "STORY_NAME";
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Set this activity into fullscreen...
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        // Get the value of array strings from the previous activity...
        Intent i = getIntent();
        String[] listOfStories = i.getStringArrayExtra("LIST_OF_STORIES");
        
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_story_testament_list,listOfStories));
        ListView listOfStoriesView = getListView();
        listOfStoriesView.setTextFilterEnabled(true);
        listOfStoriesView.setBackgroundColor(Color.parseColor("#3498DB"));
        
        listOfStoriesView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(StoryTestamentListActivity.this, StoryDetailActivity.class);
                
                TextView storyTextView = (TextView) view.findViewById(R.id.txt_view_title);
                String storyName = storyTextView.getText().toString();
                
                intent.putExtra(STORY_NAME, storyName);
                startActivity(intent);
            }
        });
        
    }
    
}
