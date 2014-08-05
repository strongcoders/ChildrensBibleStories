package com.childrensbiblestories;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StoryPagerAdapter extends PagerAdapter {

	private Context context;
	private String[] stories;
	private int[] images;
	private int[] audios;
	private MediaPlayer audioPlayer = null;
	
	public StoryPagerAdapter(Context ctx, String[] storyDetails, int[] imageDetails, int[] audioDetails) {
		this.context = ctx;
		this.stories = storyDetails;
		this.images = imageDetails;
		this.audios = audioDetails;
	}
	
	@Override
	public int getCount() {
		return stories.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == ((LinearLayout) arg1);
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.viewpage_story, container, false);
		
		// Locate and set the value of ImageView component in the viewpage_story.xml...
		ImageView imageDetailsPage = (ImageView) itemView.findViewById(R.id.image_details_page);
		imageDetailsPage.setImageResource(images[position]);
		
		// Locate and set the value of TextView component in the viewpage_story.xml...
		TextView storyDetailsPage = (TextView) itemView.findViewById(R.id.story_details_page);
		storyDetailsPage.setText(stories[position]);
		
		// Add the viewpage_story.xml to ViewPager...
		ViewPager viewPager = (ViewPager) container;
		viewPager.addView(itemView);
		
		// Set the OnPageChangeListener...
		viewPager.setOnPageChangeListener(onPageListener);
		
		return itemView;
	}
	
	@Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpage_story.xml from ViewPager...
        ((ViewPager) container).removeView((LinearLayout) object);
    }
	
	public OnPageChangeListener onPageListener = new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			if (audioPlayer != null) {
				audioPlayer.reset();
				audioPlayer.release();
			}
			
			// Before initializing the audio player, check first if 
			// there is an audio file inside the /res/raw folder.
			if (audios[arg0] != 0) {
				audioPlayer = MediaPlayer.create(context, audios[arg0]);
				audioPlayer.start();
			}
			
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
		
	};

}
