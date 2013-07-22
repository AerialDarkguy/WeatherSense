package com.example.weathersense;

import android.app.Activity;

import android.os.Bundle;

import android.content.Intent;

import android.content.pm.PackageManager;

import android.content.pm.ResolveInfo;

import android.speech.RecognizerIntent;

import android.speech.tts.TextToSpeech;

import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.ImageButton;

import android.widget.ListView;

import java.util.ArrayList;

import java.util.List;


public class VoiceActivity extends Activity implements TextToSpeech.OnInitListener
{
 
    private static final int REQUEST_CODE = 1234;
    private ListView wordsList;
    private TextToSpeech tts1;
 
    //Called with the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_recog);
 
        ImageButton speakButton = (ImageButton) findViewById(R.id.speakButton);
        tts1 = new TextToSpeech(this, this);
        wordsList = (ListView) findViewById(R.id.list);
        tts1.setSpeechRate((float) .9);
 
        // Disable button if no recognition service is present
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(
                new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0)
        {
            speakButton.setEnabled(false);
          //  speakButton.setText("Recognizer not present");
        }
    }
    
    @Override
    public void onDestroy() {
        // Don't forget to shut down tts!
        if (tts1 != null) {
            tts1.stop();
            tts1.shutdown();
        }
        super.onDestroy();
    }
 
    //Handle the action of the button being clicked.
    public void speakButtonClicked(View v)
    {
        startVoiceRecognitionActivity();
    }
 
    //Fire an intent to start the voice recognition activity.
    private void startVoiceRecognitionActivity()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voice recognition Demo...");
        startActivityForResult(intent, REQUEST_CODE);
        
    }
 
    //Handle the results from the voice recognition activity.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            // Populate the wordsList with the String values the recognition engine thought it heard
            ArrayList<String> matches = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            wordsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                    matches));
            if ("1".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("It is currently 78 degrees outside.",TextToSpeech.QUEUE_FLUSH, null);
            	//tts1.speak("It is currently " +temp+ "degrees outside."), TextToSpeech.QUEUE_FLUSH, null);
            	
            } 
            
            else if ("one".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("It is currently 78 degrees outside.",TextToSpeech.QUEUE_FLUSH, null);
            	//tts1.speak("It is currently " +temp+ "degrees outside."), TextToSpeech.QUEUE_FLUSH, null);

            }
            
            else if ("One".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("It is currently 78 degrees outside.",TextToSpeech.QUEUE_FLUSH, null);
            	//tts1.speak("It is currently " +temp+ "degrees outside."), TextToSpeech.QUEUE_FLUSH, null);

            }
            
            else if ("2".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("Right now, the pressure outside is 1013 hectopascals. The minimum temperature is 72 degrees, and the maximum is 82 degrees. The wind is now moving at 1.1 miles per hour, and the outside humidity is 57 percent.",TextToSpeech.QUEUE_FLUSH, null);
            	//tts1.speak("Right now, the pressure outside is" +pressure+ "hectopascals. The minimum temperature is " +temp_min+ "degrees, and the maximum is " +temp_max+ "degrees. The wind is now moving at " +speed+ "miles per hour, and the outside humidity is " +humidity+ "percent.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else if ("two".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("Right now, the pressure outside is 1013 hectopascals. The minimum temperature is 72 degrees, and the maximum is 82 degrees. The wind is moving at 1.1 meters per second, and the outside humidity is 57 percent.",TextToSpeech.QUEUE_FLUSH, null);
            	//tts1.speak("Right now, the pressure outside is" +pressure+ "hectopascals. The minimum temperature is " +temp_min+ "degrees, and the maximum is " +temp_max+ "degrees. The wind is now moving at " +speed+ "miles per hour, and the outside humidity is " +humidity+ "percent.",TextToSpeech.QUEUE_FLUSH, null);

            }
            
            else if ("Two".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("Right now, the pressure outside is 1013 hectopascals. The minimum temperature is 72 degrees, and the maximum is 82 degrees. The wind is moving at 1.1 meters per second, and the outside humidity is 57 percent.",TextToSpeech.QUEUE_FLUSH, null);
            	//tts1.speak("Right now, the pressure outside is" +pressure+ "hectopascals. The minimum temperature is " +temp_min+ "degrees, and the maximum is " +temp_max+ "degrees. The wind is now moving at " +speed+ "miles per hour, and the outside humidity is " +humidity+ "percent.",TextToSpeech.QUEUE_FLUSH, null);

            }
            
            else if ("to".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("Right now, the pressure outside is 1013 hectopascals. The minimum temperature is 72 degrees, and the maximum is 82 degrees. The wind is moving at 1.1 meters per second, and the outside humidity is 57 percent.",TextToSpeech.QUEUE_FLUSH, null);
            	//tts1.speak("Right now, the pressure outside is" +pressure+ "hectopascals. The minimum temperature is " +temp_min+ "degrees, and the maximum is " +temp_max+ "degrees. The wind is now moving at " +speed+ "miles per hour, and the outside humidity is " +humidity+ "percent.",TextToSpeech.QUEUE_FLUSH, null);

            }
            
            else if ("To".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("Right now, the pressure outside is 1013 hectopascals. The minimum temperature is 72 degrees, and the maximum is 82 degrees. The wind is moving at 1.1 meters per second, and the outside humidity is 57 percent.",TextToSpeech.QUEUE_FLUSH, null);
            	//tts1.speak("Right now, the pressure outside is" +pressure+ "hectopascals. The minimum temperature is " +temp_min+ "degrees, and the maximum is " +temp_max+ "degrees. The wind is now moving at " +speed+ "miles per hour, and the outside humidity is " +humidity+ "percent.",TextToSpeech.QUEUE_FLUSH, null);

            }
            
            else if ("too".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("Right now, the pressure outside is 1013 hectopascals. The minimum temperature is 72 degrees, and the maximum is 82 degrees. The wind is moving at 1.1 meters per second, and the outside humidity is 57 percent.",TextToSpeech.QUEUE_FLUSH, null);
            	//tts1.speak("Right now, the pressure outside is" +pressure+ "hectopascals. The minimum temperature is " +temp_min+ "degrees, and the maximum is " +temp_max+ "degrees. The wind is now moving at " +speed+ "miles per hour, and the outside humidity is " +humidity+ "percent.",TextToSpeech.QUEUE_FLUSH, null);

            }
            
            else if ("Too".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("Right now, the pressure outside is 1013 hectopascals. The minimum temperature is 72 degrees, and the maximum is 82 degrees. The wind is moving at 1.1 meters per second, and the outside humidity is 57 percent.",TextToSpeech.QUEUE_FLUSH, null);
            	//tts1.speak("Right now, the pressure outside is" +pressure+ "hectopascals. The minimum temperature is " +temp_min+ "degrees, and the maximum is " +temp_max+ "degrees. The wind is now moving at " +speed+ "miles per hour, and the outside humidity is " +humidity+ "percent.",TextToSpeech.QUEUE_FLUSH, null);

            }
            
            else if ("3".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("On 7 23 2013, the low will be 74 degrees and the high will be 82 degrees. On 7 24 2013, the low will be 72 degrees and the high will be 82 degrees. On 7 25 2013, the low will be 72 degrees and the high will be 78 degrees.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else if ("three".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("On 7 23 2013, the low will be 74 degrees and the high will be 82 degrees. On 7 24 2013, the low will be 72 degrees and the high will be 82 degrees. On 7 25 2013, the low will be 72 degrees and the high will be 78 degrees.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else if ("Three".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("This will give you a five day weather forecast.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else if ("4".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("This will give you clothing suggestions based on the current weather.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else if ("four".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("This will give you clothing suggestions based on the current weather.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else if ("Four".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("This will give you clothing suggestions based on the current weather.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else if ("for".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("This will give you clothing suggestions based on the current weather.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else if ("For".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("This will give you clothing suggestions based on the current weather.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else if ("hello".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("Hi. What's up?",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else if ("not much".contentEquals((String) wordsList.getAdapter().getItem(0))) {
            	tts1.speak("Good to know.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
            else {
            	tts1.speak("Unfortunately, that command wasn't recognized as a menu item. Please click the screen and speak to try again.",TextToSpeech.QUEUE_FLUSH, null);
            }
            
        }
        
        super.onActivityResult(requestCode, resultCode, data);
    }

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	}
}
