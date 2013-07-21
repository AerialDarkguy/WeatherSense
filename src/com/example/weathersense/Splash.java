package com.example.weathersense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity{
	
	//ImageView background;
	
	Intent in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		in = new Intent("MAIN");
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					startActivity(in);
				}
			}
		};
		
		timer.start();
		
		//background = (ImageView)findViewById(R.drawable.ws1);
		//background.setOnClickListener(this);
		
		
		
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	
}
