package com.example.weathersense;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherHttp {
	
	private static String sURL; 
	
	public static String getData(int la, int lo){
		
		//sURL = "http://api.openweathermap.org/data/2.5/forecast?lat=" + la + "&lon=" + lo;
		sURL = "api.openweathermap.org/data/2.5/weather?q=Philadelphia,us";
		
		HttpURLConnection con = null;
		InputStream is = null;
		
		try{
			con = (HttpURLConnection) (new URL(sURL)).openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();
			
			StringBuffer buffer = new StringBuffer();
			is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String line = null;
			
			while((line=br.readLine()) != null)
				buffer.append(line + "\r\n");
		
			is.close();
			con.disconnect();
			return buffer.toString();
		}catch(Throwable t){
			t.printStackTrace();
		}finally{
			try{
				is.close();
			}catch(Throwable t){}
			try{
				con.disconnect();
			}catch(Throwable t){}
		}
		return null;
	}
}
