package ca.ualberta.cs.lonelytwitter.test;

import org.apache.http.entity.StringEntity;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.R;
import android.test.ViewAsserts;

public class IntentReaderActivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTest() {
		super(IntentReaderActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testSendText(){
		String text = "Hello world";
		int code = IntentReaderActivity.NORMAL;
		IntentReaderActivity activity = startwithText(text, code);
		assertEquals("Is the text correct?", text, activity.getText());
		
	}
	public void testDisplayText(){
		String text = "Hello world";
		IntentReaderActivity activty = startwithText(text, IntentReaderActivity.NORMAL);
		assertEquals("Correct text?", text,activty.getText());
		
		TextView view = (TextView) activty.findViewById(R.id.intentText);
		assertEquals("Displays correct text?",text,view.getText().toString());
	}
	
	
	private IntentReaderActivity startwithText(String text,int code){
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY,text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, code);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
	}
	public void testDoubleText(){
		String text ="Hello";
		IntentReaderActivity activity = startwithText(text,IntentReaderActivity.DOUBLE);
		assertEquals("DOuble transform workiing?", text+text, activity.getText());
	}
	public void testReverseText(){
		String text = "Hello";
		String rtext = "olleH";
		IntentReaderActivity activity = startwithText(text, IntentReaderActivity.REVERSE);
		assertEquals("Reverse Works?", rtext,activity.getText());
	}
	public void testEmptyDisplayTextMsg(){
		String text = "Empty";
		IntentReaderActivity activity = startwithText(null, IntentReaderActivity.NORMAL);
		if(activity.getText() == null ){
			TextView textview = (TextView) activity.findViewById(R.id.intentText);
			assertEquals("Empty == Empty",text,textview.getText());
			
		}
	}
	
	
	
	public void testTextView(){
		IntentReaderActivity activity = startwithText(null, IntentReaderActivity.NORMAL);
		
		android.test.ViewAsserts.assertOnScreen (origin, view);
		activity.getWindow().getDecorView();
	}

}
