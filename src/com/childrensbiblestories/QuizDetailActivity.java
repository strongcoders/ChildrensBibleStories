package com.childrensbiblestories;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

public class QuizDetailActivity extends Activity {
	
	private ViewPager quizPager;
	private PagerAdapter quizPagerAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
        // Set this activity into fullscreen...
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        // Instantiate the ViewPager...
        setContentView(R.layout.activity_quiz_detail);
        quizPager = (ViewPager) findViewById(R.id.quiz_pager);
        
        String[] questions = getResources().getStringArray(R.array.quiz_questions);
        quizPagerAdapter = new QuizPagerAdapter(QuizDetailActivity.this, questions);
        quizPager.setAdapter(quizPagerAdapter);
	}
	
}
