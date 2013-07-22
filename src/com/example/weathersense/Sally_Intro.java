package com.example.weathersense;
 
import java.util.Locale;
 
import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;

import android.speech.tts.TextToSpeech;

import android.util.Log;
 
public class Sally_Intro extends Activity implements
        TextToSpeech.OnInitListener {
    /** Called when the activity is first created. */
 
    private TextToSpeech tts;

 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_recog);
 
        tts = new TextToSpeech(this, this);
 
    }
 
    @Override
    public void onDestroy() {
        // Don't forget to shut down tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
 
    @Override
    public void onInit(int status) {
 
        if (status == TextToSpeech.SUCCESS) {
 
            int result = tts.setLanguage(Locale.US);
 
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
                tts.setSpeechRate((float) .9);
            } else {
                tts.speak("Welcome to Weather Sense! Say one for the current temperature in degrees fahrenheit. Say two for a more detailed analysis of the current weather. Say three for a three day forecast. Say four for clothing suggestions based on the current weather. Tap anywhere on the screen to start speaking!",TextToSpeech.QUEUE_FLUSH, null);
            }
 
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
        
        Intent otherIntent = new Intent(this, VoiceActivity.class);
        
        startActivity(otherIntent);
 
    }
 }