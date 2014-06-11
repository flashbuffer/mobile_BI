package com.example.mobile_bi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;

public class JsonPost {
	HttpURLConnection httpcon;  

	private static String[] waitSymbols={"|", "/","--","\\"};
	public static List WAIT_SYMBOL_LIST;
	public static JsonPost INSTANCE = new JsonPost();
	int  waitCount=0;
	HttpPostTask task;
	
	static{
		WAIT_SYMBOL_LIST  =new ArrayList();
		for(String symbol:waitSymbols){
			WAIT_SYMBOL_LIST.add(symbol);
		}
	}
	private JsonPost(){
		
	}
	
	public void startTask(String url, String data){
		task = new HttpPostTask();
		task.execute(url, data);
	}
	
	public  String getReportNames(){
		if (task.getStatus() != Status.FINISHED){
			return waitSymbols[waitCount++ % waitSymbols.length];
		}
		try {
			return task.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private class HttpPostTask extends AsyncTask<String, Void, String> {
	    @Override
	    protected String doInBackground(String... urls) {
			try {
				//Connect
				httpcon = (HttpURLConnection) ((new URL (urls[0]).openConnection()));
				httpcon.setDoOutput(true);
				httpcon.setRequestProperty("Content-Type", "application/json");
				httpcon.setRequestProperty("Accept", "application/json");
				httpcon.setRequestMethod("POST");
				httpcon.connect();
				
				//Write         
				OutputStream os = httpcon.getOutputStream();
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
				writer.write(urls[1]);
				writer.close();
				os.close();

				//Read      
				BufferedReader br = new BufferedReader(new InputStreamReader(httpcon.getInputStream(),"UTF-8"));

				String line = null; 
				StringBuilder sb = new StringBuilder();         

				while ((line = br.readLine()) != null) {  
				     sb.append(line); 
				}       
				

				br.close();  
				return sb.toString();
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }
	}

}
