package com.childrensbiblestories;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizPagerAdapter extends PagerAdapter {

	private Context context;
	private String[] questions;
	
	public QuizPagerAdapter(Context ctx, String[] questions) {
		this.context = ctx;
		this.questions = questions;
	}
	
	@Override
	public int getCount() {
		return questions.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == ((LinearLayout) arg1);
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.viewpage_quiz, container, false);
		
		// Locate and set the value of TextView component in the viewpage_quiz.xml...
		TextView quizDetailsPage = (TextView) itemView.findViewById(R.id.quiz_details_page);
		quizDetailsPage.setText(questions[position]);
		
		// Locate and set the radio button for the radio group set in the viewpage_quiz.xml...
		RadioGroup answerGroup = (RadioGroup) itemView.findViewById(R.id.answer_group);
		String[] answers = null;
		
		switch (position) {
			case 0:
				answers = itemView.getResources().getStringArray(R.array.answer_set_1);
				break;
			
			case 1:
				answers = itemView.getResources().getStringArray(R.array.answer_set_2);
				break;
				
			case 2:
				answers = itemView.getResources().getStringArray(R.array.answer_set_3);
				break;
				
			case 3:
				answers = itemView.getResources().getStringArray(R.array.answer_set_4);
				break;
				
			case 4:
				answers = itemView.getResources().getStringArray(R.array.answer_set_5);
				break;
				
			case 5:
				answers = itemView.getResources().getStringArray(R.array.answer_set_6);
				break;
				
			case 6:
				answers = itemView.getResources().getStringArray(R.array.answer_set_7);
				break;
				
			case 7:
				answers = itemView.getResources().getStringArray(R.array.answer_set_8);
				break;
				
			case 8:
				answers = itemView.getResources().getStringArray(R.array.answer_set_9);
				break;
				
			case 9:
				answers = itemView.getResources().getStringArray(R.array.answer_set_10);
				break;
		}
		
		for (int x=0; x < answers.length; x++) {
			RadioButton rbAnswer = new RadioButton(context);
			rbAnswer.setId(x);
			rbAnswer.setText(answers[x]);
			answerGroup.addView(rbAnswer);
		}
		
		// Add the viewpage_quiz.xml to ViewPager...
		ViewPager viewPager = (ViewPager) container;
		viewPager.addView(itemView);
				
		return itemView;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpage_quiz.xml from ViewPager...
        ((ViewPager) container).removeView((LinearLayout) object);
    }

}
