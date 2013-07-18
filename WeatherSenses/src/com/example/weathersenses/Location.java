package com.example.weathersenses;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;


public class Location extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		String provider = locationManager.getBestProvider(criteria, false);
		android.location.Location location = locationManager.getLastKnownLocation(provider);  //location?

		int la = (int) location.getLatitude();
		int lo = (int) location.getLongitude();
	    
	}
	
	public void onDestroy(){
		
	}

}
