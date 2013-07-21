package com.example.weathersense;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.speech.tts.TextToSpeech;


public class MainActivity extends Activity implements TextToSpeech.OnInitListener{

	public TextToSpeech tts;
	private ImageView b;
	int la, lo;
	String sURL;
	LocationManager locationManager;
	Criteria criteria;
	String provider;
	URL url;
	HttpURLConnection request;
	JsonParser jp;
	JsonElement root;
	JsonObject rootobj;
	double temp;
	String hum;
	String data;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tts = new TextToSpeech(this, this);
        b = (ImageView)findViewById(R.id.main_pic);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//location stuff
				locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				criteria = new Criteria();
				provider = locationManager.getBestProvider(criteria, false);
				android.location.Location location = locationManager.getLastKnownLocation(provider);  //location?

				la = (int) location.getLatitude();
				lo = (int) location.getLongitude();
				data = WeatherHttp.getData(la,lo);
				DataCollection.syncData(data);
				/*
				sURL = "http://api.openweathermap.org/data/2.5/forecast?lat=" + la + "&lon=" + lo;
				
				try {
					//where we fetch data, store it in DataCollection
					url = new URL(sURL);
					request  = (HttpURLConnection) url.openConnection();
					request.connect();
					
					//convert to json object to print data
					jp = new JsonParser();
					root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
					rootobj = root.getAsJsonObject();
					
					//get some data elements and print them
					//String city = rootobj.get("name").getAsString();
					//System.out.println("Name: " + city);
					
					temp = rootobj.get("main").getAsJsonObject().get("temp").getAsDouble();
					//DataCollection.setTemp(temp);
					//System.out.println("Temp: " + temp);
					tts.speak("Temperature is " + temp, TextToSpeech.QUEUE_FLUSH, null);
					
					hum = rootobj.get("main").getAsJsonObject().get("humidity").getAsString();
					//DataCollection.setHum(hum);
					//System.out.println("Humidity: " + hum + "%");
					tts.speak("Humidity is " + hum, TextToSpeech.QUEUE_FLUSH, null);
					
					//5 day thingy
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			*/
			}
		});
        
    }

    
    @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		// Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
	}
	

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if (status == TextToSpeech.SUCCESS) {
			 
            int result = tts.setLanguage(Locale.US);
 
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                tts.speak("Tap on the screen to get weather data for the day", TextToSpeech.QUEUE_FLUSH, null);//give directions
            }
 
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
	}


	
	
    
}
