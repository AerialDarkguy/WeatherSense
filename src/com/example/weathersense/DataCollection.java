package com.example.weathersense;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DataCollection {

	
	private static double temp;
	private static String hum;
	//private static String data;
	
	
	private static JsonParser jp;
	private static JsonElement root;
	private static JsonObject rootobj;
	
	public static void syncData(String data){
		jp = new JsonParser();
		root = jp.parse(data);
		rootobj = root.getAsJsonObject();
		
		temp = rootobj.get("main").getAsJsonObject().get("temp").getAsDouble();
		hum = rootobj.get("main").getAsJsonObject().get("hum").getAsString();
	}
	
	public double getTemp(){
		return temp;
	}
	
	public String getHum(){
		return hum;
	}
	
	
	
	/*
	public static void setTemp(double t){
		temp = t;
	}
	public double getTemp(){
		return temp;
	}
	public static void setHum(String h){
		hum = h;
	}
	public String getHum(){
		return hum;
	}
	public static void setData(String d){
		data = d;
	}
	*/
}
