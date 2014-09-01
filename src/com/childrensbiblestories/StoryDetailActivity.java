package com.childrensbiblestories;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;
import android.view.WindowManager;

public class StoryDetailActivity extends Activity {

	private ViewPager storyPager;
	private PagerAdapter storyPagerAdapter;
	private MediaPlayer audioPlayer = null;
	private int[] audioDetails = null;
	
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
        
        if (storyName.equalsIgnoreCase("Adam and Eve")) {
        	
        	storyDetails = getResources().getStringArray(R.array.adam_and_eve);
        	imageDetails = new int[] {R.drawable.adam_and_eve1, R.drawable.adam_and_eve2, R.drawable.adam_and_eve3, 
        			R.drawable.adam_and_eve4, R.drawable.adam_and_eve5, R.drawable.adam_and_eve6, R.drawable.adam_and_eve7, 
        			R.drawable.adam_and_eve8, R.drawable.adam_and_eve9, R.drawable.adam_and_eve10, R.drawable.adam_and_eve11};
        	audioDetails = new int[] {R.raw.adam_and_eve1, R.raw.adam_and_eve2, R.raw.adam_and_eve3, R.raw.adam_and_eve4, 
        			R.raw.adam_and_eve5, R.raw.adam_and_eve6, R.raw.adam_and_eve7, R.raw.adam_and_eve8, R.raw.adam_and_eve9, 
        			R.raw.adam_and_eve10, R.raw.adam_and_eve11};
        	
        }
        
        if (storyName.equalsIgnoreCase("Noah's Ark")) {
        	
        	storyDetails = getResources().getStringArray(R.array.noahs_ark);
        	imageDetails = new int[] {R.drawable.noah1, R.drawable.noah2, R.drawable.noah3, 
        			R.drawable.noah4, R.drawable.noah5, R.drawable.noah6, R.drawable.noah7, 
        			R.drawable.noah8, R.drawable.noah9, R.drawable.noah10, R.drawable.noah11,
        			R.drawable.noah12};
        	audioDetails = new int[] {R.raw.noah1, R.raw.noah2, R.raw.noah3, R.raw.noah4, R.raw.noah5, R.raw.noah6, 
        			R.raw.noah7, R.raw.noah8, R.raw.noah9, R.raw.noah10, R.raw.noah11, R.raw.noah12};
        	
        }
        
        if (storyName.equalsIgnoreCase("David and Goliath")) {
        	
        	storyDetails = getResources().getStringArray(R.array.david_and_goliath);
        	imageDetails = new int[] {R.drawable.david_and_goliath1, R.drawable.david_and_goliath2, R.drawable.david_and_goliath3, 
        			R.drawable.david_and_goliath4, R.drawable.david_and_goliath5, R.drawable.david_and_goliath6, R.drawable.david_and_goliath7, 
        			R.drawable.david_and_goliath8, R.drawable.david_and_goliath9};
        	audioDetails = new int[] {R.raw.david1, R.raw.david2,R.raw.david3, R.raw.david4, R.raw.david5, R.raw.david6, 
        			R.raw.david7, R.raw.david8, R.raw.david9};
        	
        }
        
        if (storyName.equalsIgnoreCase("The Birth of Jesus")) {
        	
        	storyDetails = getResources().getStringArray(R.array.the_story_of_christmas);
        	imageDetails = new int[] {R.drawable.christmas1, R.drawable.christmas2, R.drawable.christmas3, 
        			R.drawable.christmas4, R.drawable.christmas5, R.drawable.christmas6, R.drawable.christmas7, 
        			R.drawable.christmas8, R.drawable.christmas9, R.drawable.christmas10, R.drawable.christmas11,
        			R.drawable.christmas12, R.drawable.christmas13};
        	audioDetails = new int[] {R.raw.birth_1, R.raw.birth_2, R.raw.birth_3, R.raw.birth_4, 
        			R.raw.birth_5, R.raw.birth_6, R.raw.birth_7, R.raw.birth_8, R.raw.birth_9, 
        			R.raw.birth_10, R.raw.birth_11, R.raw.birth_12, R.raw.birth_13};
        	
        } 
        
        if (storyName.equalsIgnoreCase("The Parable of the Prodigal Son")) {
        	storyDetails = getResources().getStringArray(R.array.the_prodigal_son);
        	imageDetails = new int[] {R.drawable.prodigal_son1, R.drawable.prodigal_son2, R.drawable.prodigal_son3, 
        			R.drawable.prodigal_son4, R.drawable.prodigal_son5, R.drawable.prodigal_son6, R.drawable.prodigal_son7,
        			R.drawable.prodigal_son8};
        	audioDetails = new int[] {R.raw.prodigal_1, R.raw.prodigal_2, R.raw.prodigal_3, R.raw.prodigal_4, 
        			R.raw.prodigal_5, R.raw.prodigal_6, R.raw.prodigal_7, R.raw.prodigal_8};
        }
        
        if (storyName.equalsIgnoreCase("The Parable of Good Samaritan")) {
        	storyDetails = getResources().getStringArray(R.array.the_good_samaritan);
        	imageDetails = new int[] {R.drawable.samaritan1, R.drawable.samaritan2, R.drawable.samaritan3, 
        			R.drawable.samaritan4, R.drawable.samaritan5, R.drawable.samaritan6, R.drawable.samaritan7};
        	audioDetails = new int[] {R.raw.samaritan1, R.raw.samaritan2, R.raw.samaritan3, R.raw.samaritan4, R.raw.samaritan5, 
        			R.raw.samaritan6, R.raw.samaritan7};
        }
        
        storyPagerAdapter = new StoryPagerAdapter(StoryDetailActivity.this, storyDetails, imageDetails);
        storyPager.setAdapter(storyPagerAdapter);
        storyPager.setOnPageChangeListener(onPageListener);
        
        // Instantiate the first audio of the story...
        storyPager.getCurrentItem();
        
        if (audioDetails[0] != 0) {
        	audioPlayer = MediaPlayer.create(this, audioDetails[0]);
        }
        
    }
    
    public OnPageChangeListener onPageListener = new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// Before initializing the audio player, check first if 
			// there is an audio file inside the /res/raw folder.
			if (audioDetails[arg0] != 0) {
				// If the play audio settings is checked, play the audio else, don't play...
				SharedPreferences sharedPref = StoryDetailActivity.this.getSharedPreferences("AudioPlay", Context.MODE_PRIVATE);
				boolean isAudioPlay = sharedPref.getBoolean("is_audio_play", false);
				
				if (isAudioPlay == true) {
					audioPlayer = MediaPlayer.create(StoryDetailActivity.this, audioDetails[arg0]);
					audioPlayer.start();
				}
				
			}
			
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// This will stop the audio playing while dragging 
			// the page to the left or to the right...
			if (arg0 == ViewPager.SCROLL_STATE_DRAGGING) {
				if (audioPlayer != null && audioPlayer.isPlaying()) {
					audioPlayer.stop();
					audioPlayer.release();
				}
			}
		}
		
	};
    
    @Override
    public void onStart() {
    	if (audioPlayer != null) {
    		// If the play audio settings is checked, play the audio else, don't play...
            SharedPreferences sharedPref = getSharedPreferences("AudioPlay", Context.MODE_PRIVATE);
            boolean isAudioPlay = sharedPref.getBoolean("is_audio_play", false);
    		
            if (isAudioPlay == true) {
            	audioPlayer.start();
            }
    	}
    	
    	super.onStart();
    }
    
    @Override
    public void onBackPressed() {
    	if (audioPlayer != null) {
    		audioPlayer.stop();
    		audioPlayer.release();
    	}
    	
    	super.onBackPressed();
    }
    
}
