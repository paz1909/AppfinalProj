package org.apache.cordova.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.json.*;

import android.webkit.JavascriptInterface;

public class Functions {
	@JavascriptInterface
	public String signIn(String userName, String pass) {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		String ret;

		URL serverAddress = null;

		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/signIn.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			//connection.setDoOutput(true);
			connection.setReadTimeout(10000);
			connection.setRequestProperty("userName", userName);
			connection.setRequestProperty("password", pass);
			//connection = (HttpURLConnection) serverAddress.openConnection();

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			  wr = new OutputStreamWriter(connection.getOutputStream());
			  wr.write(""); 
			  wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			ret = sb.toString();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = "false1";
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = "false2";
		} catch (IOException e) {
			e.printStackTrace();
			ret = "false3";
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}
	
	@JavascriptInterface
	public String approveNewVolunteersInit() {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		String ret;

		URL serverAddress = null;

		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/approveNewVolunteersInit.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			//connection.setDoOutput(true);
			connection.setReadTimeout(10000);
			//connection = (HttpURLConnection) serverAddress.openConnection();

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			  wr = new OutputStreamWriter(connection.getOutputStream());
			  wr.write(""); 
			  wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			ret = sb.toString();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = "false1";
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = "false2";
		} catch (IOException e) {
			e.printStackTrace();
			ret = "false3";
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}

	@JavascriptInterface
	public String allVolunteersInit() {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		String ret;

		URL serverAddress = null;

		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/allVolunteersInit.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			//connection.setDoOutput(true);
			connection.setReadTimeout(10000);
			//connection = (HttpURLConnection) serverAddress.openConnection();

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			  wr = new OutputStreamWriter(connection.getOutputStream());
			  wr.write(""); 
			  wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			ret = sb.toString();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = "false1";
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = "false2";
		} catch (IOException e) {
			e.printStackTrace();
			ret = "false3";
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}

	@JavascriptInterface
	public Boolean chooseMap(String mapName) {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		Boolean ret;

		URL serverAddress = null;

		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/chooseMap.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setReadTimeout(10000);
			connection.setRequestProperty("mapName", mapName);
			connection = (HttpURLConnection) serverAddress.openConnection();

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			 * wr = new OutputStreamWriter(connection.getOutputStream());
			 * wr.write(""); wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			String result = sb.toString();
			ret = Boolean.parseBoolean(result);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = false;
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = false;
		} catch (IOException e) {
			e.printStackTrace();
			ret = false;
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}
	@JavascriptInterface
	public String chooseMapInit() {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		String ret;

		URL serverAddress = null;

		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/chooseMapsInit.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setReadTimeout(10000);
			connection = (HttpURLConnection) serverAddress.openConnection();

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			 * wr = new OutputStreamWriter(connection.getOutputStream());
			 * wr.write(""); wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			ret = sb.toString();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = "false";
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = "false";
		} catch (IOException e) {
			e.printStackTrace();
			ret = "false";
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}
	
	@JavascriptInterface
	public String signUp(String firstName,String lastName,String userName,String pass,String id,String phoneNumber,String email) {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		String ret;

		URL serverAddress = null;

		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/signUp.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(10000);
			connection.setRequestProperty("firstName", firstName);
			connection.setRequestProperty("lastName", lastName);
			connection.setRequestProperty("userName", userName);
			connection.setRequestProperty("password", pass);
			connection.setRequestProperty("id", id);
			connection.setRequestProperty("phoneNumber", phoneNumber);
			connection.setRequestProperty("email", email);

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			 * wr = new OutputStreamWriter(connection.getOutputStream());
			 * wr.write(""); wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			ret = sb.toString();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = "false1";
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = "false2";
		} catch (IOException e) {
			e.printStackTrace();
			ret = "false3";
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}
	@JavascriptInterface
	public Boolean switchMap(String userName) {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		Boolean ret;

		URL serverAddress = null;

		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/switchMap.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(10000);
			connection.setRequestProperty("userName", userName);

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			 * wr = new OutputStreamWriter(connection.getOutputStream());
			 * wr.write(""); wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			String result = sb.toString();
			ret = Boolean.parseBoolean(result);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = false;
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = false;
		} catch (IOException e) {
			e.printStackTrace();
			ret = false;
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}
	@JavascriptInterface
	public Boolean approveNewVolunteers(String[] jsonArr) {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		Boolean ret;

		URL serverAddress = null;
		
		String json = createJson(jsonArr);
		
		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/approveNewVolunteers.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(10000);
			connection.setRequestProperty("json", json);

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			 * wr = new OutputStreamWriter(connection.getOutputStream());
			 * wr.write(""); wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			String result = sb.toString();
			ret = Boolean.parseBoolean(result);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = false;
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = false;
		} catch (IOException e) {
			e.printStackTrace();
			ret = false;
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}

	private String createJson(String[] jsonArr) {
		String jsonRet = null;
		JSONObject obj;
		obj = new JSONObject();
		try {
			obj.put("arrayLength", jsonArr.length);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (String id : jsonArr) {
			try {
				obj.accumulate("volunteers", new JSONObject().put("id", id));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		jsonRet = obj.toString();
		return jsonRet;
	}
	
	
	@JavascriptInterface
	public String allMapsInit() {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		String ret;

		URL serverAddress = null;

		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/allMapsInit.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			//connection.setDoOutput(true);
			connection.setReadTimeout(10000);
			//connection = (HttpURLConnection) serverAddress.openConnection();

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			  wr = new OutputStreamWriter(connection.getOutputStream());
			  wr.write(""); 
			  wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			ret = sb.toString();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = "false1";
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = "false2";
		} catch (IOException e) {
			e.printStackTrace();
			ret = "false3";
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}
	
	@JavascriptInterface
	public String allFamiliesInit() {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		String ret;

		URL serverAddress = null;

		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/allFamiliesInit.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			//connection.setDoOutput(true);
			connection.setReadTimeout(10000);
			//connection = (HttpURLConnection) serverAddress.openConnection();

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			  wr = new OutputStreamWriter(connection.getOutputStream());
			  wr.write(""); 
			  wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			ret = sb.toString();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = "false1";
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = "false2";
		} catch (IOException e) {
			e.printStackTrace();
			ret = "false3";
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}
	@JavascriptInterface
	public String test() {
		HttpURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line = null;
		String ret;

		URL serverAddress = null;

		try {
			serverAddress = new URL(
					"http://env-3010859.jelastic.servint.net/Controller/test.jsp");

			// Set up the initial connection
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");
			//connection.setDoOutput(true);
			connection.setReadTimeout(10000);
			//connection = (HttpURLConnection) serverAddress.openConnection();

			// get the output stream writer and write the output to the server
			// not needed in this example
			/*
			  wr = new OutputStreamWriter(connection.getOutputStream());
			  wr.write(""); 
			  wr.flush();
			 */

			// read the result from the server
			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			ret = sb.toString();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			ret = "false1";
		} catch (ProtocolException e) {
			e.printStackTrace();
			ret = "false2";
		} catch (IOException e) {
			e.printStackTrace();
			ret = "false3";
		} finally {
			// close the connection, set all objects to null
			connection.disconnect();
			rd = null;
			sb = null;
			wr = null;
			connection = null;
			
		}
		return (ret);
	}
}