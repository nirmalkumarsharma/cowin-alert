package in.nks.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.nks.app.entity.Center;
import in.nks.app.entity.CenterSearchResponse;
import in.nks.app.entity.Session;

public class SlotFinder {
	public static void main(String[] args) {
		String cowinURL = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/calendarByDistrict?district_id=777&date=14-05-2021";
		ObjectMapper mapper = new ObjectMapper();
		int retries = 100;

		while (retries-- > 0) {
			System.out.println("Remaining : " + retries);
			try {
				URL url = new URL(cowinURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Eclipse 4.16.0");
				int responseCode = con.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine = "";
					StringBuffer response = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					CenterSearchResponse centerSearchResponse = mapper.readValue(response.toString(),
							CenterSearchResponse.class);
					for (Center center : centerSearchResponse.getCenters()) {
						for (Session session : center.getSessions()) {
							Integer availableCapacity = session.getAvailableCapacity();
							if (session.getAvailableCapacity() > 0 && session.getMinAgeLimit() == 18) {
								System.out.println(center.getName() + " | " + center.getAddress() + ", "+ center.getPincode() + " Available = " + availableCapacity);
							}
						}
					}
				}
				Thread.sleep(5000);
			} catch (Exception e) {
				System.err.println("Error ocurred while connecting");
			}
		}
	}
}
