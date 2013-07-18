package com.example.weathersenses;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Screen extends Activity {

	Button b;
	int la,lo;
	String sURL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		b = (Button)findViewById(R.id.the_button);
		b.setOnClickListener(new View.OnClickListener() {
			//opens api on button click
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				Criteria criteria = new Criteria();
				String provider = locationManager.getBestProvider(criteria, false);
				android.location.Location location = locationManager.getLastKnownLocation(provider);  //location?

				la = (int) location.getLatitude();
				lo = (int) location.getLongitude();
				
				sURL = "http://api.openweathermap.org/data/2.5/forecast?lat=" + la + "&lon=" + lo;
				
				try {
					URL url = new URL(sURL);
					HttpURLConnection request  = (HttpURLConnection) url.openConnection();
					request.connect();
					
					//convert to json object to print data
					JsonParser jp = new JsonParser();
					JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
					JsonObject rootobj = root.getAsJsonObject();
					
					//get some data elements and print them
					//String city = rootobj.get("name").getAsString();
					//System.out.println("Name: " + city);
					
					double temp = rootobj.get("main").getAsJsonObject().get("temp").getAsDouble();
					System.out.println("Temp: " + temp);
					
					String hum = rootobj.get("main").getAsJsonObject().get("humidity").getAsString();
					System.out.println("Humidity: " + hum + "%");
					
					
					//5 day thingy
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}



}
