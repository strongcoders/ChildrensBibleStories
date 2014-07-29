package com.childrensbiblestories;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
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
	
	public StoryPagerAdapter(Context ctx, String[] storyDetails, int[] imageDetails) {
		this.context = ctx;
		this.stories = storyDetails;
		this.images = imageDetails;
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
		((ViewPager) container).addView(itemView);
		
		return itemView;
	}
	
	@Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpage_story.xml from ViewPager...
        ((ViewPager) container).removeView((LinearLayout) object);
    }

}
