package com.childrensbiblestories;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

public class StoryDetailActivity extends Activity {

	private ViewPager storyPager;
	private PagerAdapter storyPagerAdapter;
	private MediaPlayer audioPlayer = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Set this activity into fullscreen...
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        // Instantiate the ViewPager...
        setContentView(R.layout.activity_story_detail);
        storyPager = (ViewPager) findViewById(R.id.story_pager);
        
        // Get the value of the selected story...
        Intent intent = getIntent();
        String storyName = intent.getExtras().getString("STORY_NAME");
        String[] storyDetails = null;
        int[] imageDetails = null;
        int[] audioDetails = null;
        
        if (storyName.equalsIgnoreCase("The Story of Christmas")) {
        	storyDetails = getResources().getStringArray(R.array.the_story_of_christmas);
        	imageDetails = new int[] {R.drawable.christmas1, R.drawable.christmas2, R.drawable.christmas3, 
        			R.drawable.christmas4, R.drawable.christmas5, R.drawable.christmas6, R.drawable.christmas7, 
        			R.drawable.christmas8, R.drawable.christmas9, R.drawable.christmas10, R.drawable.christmas11,
        			R.drawable.christmas12, R.drawable.christmas13};
        	audioDetails = new int[] {R.raw.storyofchristmas1, R.raw.storyofchristmas2, R.raw.storyofchristmas3,
        			R.raw.storyofchristmas4, R.raw.storyofchristmas5, R.raw.storyofchristmas6, R.raw.storyofchristmas7,
        			R.raw.storyofchristmas8, R.raw.storyofchristmas9, R.raw.storyofchristmas10, R.raw.storyofchristmas11,
        			R.raw.storyofchristmas12, R.raw.storyofchristmas13};
        }
        
        storyPagerAdapter = new StoryPagerAdapter(StoryDetailActivity.this, storyDetails, imageDetails, audioDetails);
        storyPager.setAdapter(storyPagerAdapter);
        
        // Instantiate the first audio of the story...
        storyPager.getCurrentItem();
        audioPlayer = MediaPlayer.create(this, audioDetails[0]);
        
    }
    
    @Override
    public void onStart() {
    	if (audioPlayer != null) {
    		audioPlayer.start();
    	}
    	
    	super.onStart();
    }
    
}
