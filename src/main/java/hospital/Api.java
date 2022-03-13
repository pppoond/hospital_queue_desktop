package hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;
import hospital.*;

public class Api {

	public static String HOS_NAME_SERVER = "http://192.168.100.239/hos_q/server";
	public static String HOS_NAME_CLIENT = "http://192.168.100.239/hos_q/client";

	public ArrayList<KskdepartmentModel> get(String uri) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String result = response.body();
		ObjectMapper objMapper = new ObjectMapper();
		ArrayList<KskdepartmentModel> kskList = new ArrayList<KskdepartmentModel>();
		try {
			JSONArray jsonArr = new JSONArray(result);
			for (int i = 0; i < jsonArr.length(); i++) { // iterate over the array
				JSONObject o = jsonArr.getJSONObject(i);
				KskdepartmentModel kskModel = objMapper.readValue(o.toString(), KskdepartmentModel.class);
				kskList.add(kskModel);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kskList;
	}

	public void getApi(String uri) throws Exception {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String result = response.body();
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// runGet is Add Data to Database request_queue Table
	public void runGet(String spclty, String oqueue,  String curdep_code) {

		String urlStr = HOS_NAME_CLIENT + "/api/request_queue_add/add?spclty=" + spclty + "&oqueue=" + oqueue
				+ "&curdep_code=" + curdep_code  ;
		if (urlStr.contains(" "))
			urlStr = urlStr.replace(" ", "%20");
		BufferedReader reader;
		try {
			reader = new BufferedReader(
					new InputStreamReader(((HttpURLConnection) (new URL(urlStr)).openConnection()).getInputStream(),
							Charset.forName("UTF-8")));
			String inputLine;
			while ((inputLine = reader.readLine()) != null)
				System.out.println(inputLine);
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void updateStatus(String oqueue) {
		String uri = HOS_NAME_SERVER + "/api/statusUpdate?oqueue="+oqueue;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
		HttpResponse<String> response;
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	// find Data from Database by oqueue
	public OvstModel findByOqueue(String oqueue) {
		OvstModel kskModel = null;
		String urlStr = HOS_NAME_SERVER + "/api/ovst_oqueue/" + oqueue;
		if (urlStr.contains(" "))
			urlStr = urlStr.replace(" ", "%20");
		BufferedReader reader;
		try {
			reader = new BufferedReader(
					new InputStreamReader(((HttpURLConnection) (new URL(urlStr)).openConnection()).getInputStream(),
							Charset.forName("UTF-8")));
			String inputLine;
			while ((inputLine = reader.readLine()) != null)
				try {
					ObjectMapper objMapper = new ObjectMapper();
					JSONArray jsonArr = new JSONArray(inputLine);
					if (jsonArr.length() >= 1) {
						JSONObject o = jsonArr.getJSONObject(0); // index ที่ 0
						System.out.println(o);
						kskModel = objMapper.readValue(o.toString(), OvstModel.class);
					} else {
						System.out.println("No Data");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kskModel;

	}
	
	public ArrayList<HosqDepartmentModel> getHosqAll() throws Exception {
		String urlStr = HOS_NAME_CLIENT + "/api/hosq_department";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlStr)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String result = response.body();
		ObjectMapper objMapper = new ObjectMapper();
		ArrayList<HosqDepartmentModel> hosqList = new ArrayList<HosqDepartmentModel>();
		try {
			JSONArray jsonArr = new JSONArray(result);
			for (int i = 0; i < jsonArr.length(); i++) { // iterate over the array
				JSONObject o = jsonArr.getJSONObject(i);
				HosqDepartmentModel hosqModel = objMapper.readValue(o.toString(), HosqDepartmentModel.class);
				hosqList.add(hosqModel);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hosqList;
	}
	
	
	public ArrayList<HosqDepartmentModel> getHosqOPD() throws Exception {
		String sql = "SELECT%20*%20FROM%20hosq_department%20where%20depcode%20=%20001%20or%20depcode%20=%20002%20or%20depcode%20=%20003%20or%20depcode%20=%20"
				+ "004%20or%20depcode%20=%20005%20or%20depcode%20=%20006%20or%20depcode%20=%20007%20or%20depcode%20=%20008%20or%20depcode%20=%20009" ;
		String urlStr = HOS_NAME_CLIENT + "/api/query_string?sql="+sql;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlStr)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String result = response.body();
		ObjectMapper objMapper = new ObjectMapper();
		ArrayList<HosqDepartmentModel> hosqList = new ArrayList<HosqDepartmentModel>();
		try {
			JSONArray jsonArr = new JSONArray(result);
			for (int i = 0; i < jsonArr.length(); i++) { // iterate over the array
				JSONObject o = jsonArr.getJSONObject(i);
				HosqDepartmentModel hosqModel = objMapper.readValue(o.toString(), HosqDepartmentModel.class);
				hosqList.add(hosqModel);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hosqList;
	}
	
	
	public ArrayList<HosqDepartmentModel> getHosqOPD2() throws Exception {
		String sql = "SELECT%20*%20FROM%20hosq_department%20where%20depcode%20=%20010%20or%20depcode%20=%20012%20or%20depcode%20=%20013%20or%20depcode%20=%20014"
				+ "%20or%20depcode%20=%20015%20or%20depcode%20=%20016" ;
		String urlStr = HOS_NAME_CLIENT + "/api/query_string?sql="+sql;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlStr)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String result = response.body();
		ObjectMapper objMapper = new ObjectMapper();
		ArrayList<HosqDepartmentModel> hosqList = new ArrayList<HosqDepartmentModel>();
		try {
			JSONArray jsonArr = new JSONArray(result);
			for (int i = 0; i < jsonArr.length(); i++) { // iterate over the array
				JSONObject o = jsonArr.getJSONObject(i);
				HosqDepartmentModel hosqModel = objMapper.readValue(o.toString(), HosqDepartmentModel.class);
				hosqList.add(hosqModel);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hosqList;
	}
	
	
	
	public ArrayList<OpdDepQueueModel> opdDepQueueByDepcode(String depcode) {
		ArrayList<OpdDepQueueModel> opdDepQList = new ArrayList<OpdDepQueueModel>();
		String urlStr = HOS_NAME_SERVER + "/api/opd_dep_queue2/" + depcode;
		if (urlStr.contains(" "))
			urlStr = urlStr.replace(" ", "%20");
		BufferedReader reader;
		try {
			reader = new BufferedReader(
					new InputStreamReader(((HttpURLConnection) (new URL(urlStr)).openConnection()).getInputStream(),
							Charset.forName("UTF-8")));
			String inputLine;
			while ((inputLine = reader.readLine()) != null)
				try {
					ObjectMapper objMapper = new ObjectMapper();
					
					JSONArray jsonArr = new JSONArray(inputLine);
					if (jsonArr.length() >= 1) {
						for (int i = 0; i < jsonArr.length(); i++) { // iterate over the array
							JSONObject o = jsonArr.getJSONObject(i);
							OpdDepQueueModel opdDepQModel = objMapper.readValue(o.toString(), OpdDepQueueModel.class);
							opdDepQList.add(opdDepQModel);
						}
					} else {
						System.out.println("No Data");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return opdDepQList;

	}
	
	
	
	public ArrayList<RequestQModel> requestQStatus() {
		ArrayList<RequestQModel> reqList = new ArrayList<RequestQModel>();
		String urlStr = HOS_NAME_SERVER + "/api/queueByStatus/";
		if (urlStr.contains(" "))
			urlStr = urlStr.replace(" ", "%20");
		BufferedReader reader;
		try {
			reader = new BufferedReader(
					new InputStreamReader(((HttpURLConnection) (new URL(urlStr)).openConnection()).getInputStream(),
							Charset.forName("UTF-8")));
			String inputLine;
			while ((inputLine = reader.readLine()) != null)
				try {
					ObjectMapper objMapper = new ObjectMapper();
					
					JSONArray jsonArr = new JSONArray(inputLine);
					if (jsonArr.length() >= 1) {
						for (int i = 0; i < jsonArr.length(); i++) { // iterate over the array
							JSONObject o = jsonArr.getJSONObject(i);
							RequestQModel requestQModel = objMapper.readValue(o.toString(), RequestQModel.class);
							reqList.add(requestQModel);
						}
					} else {
						System.out.println("No Data");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reqList;

	}
	
	
	
	
}
