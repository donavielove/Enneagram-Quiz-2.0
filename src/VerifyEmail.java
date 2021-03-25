/*
   Copyright 2020 Donavie Ordonez, Dennis Tye, Kenneth Doan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class VerifyEmail {
	private static String apikey="f5bf92b7cdfea83c00952cd74e281807";
	
	
	
	public static boolean checkEmail(String email) throws Exception {
		String url = "https://apilayer.net/api/check?access_key="+apikey+"&email="+email+"&smtp=1&format=1";
		
		URL urlobj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) urlobj.openConnection();
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent", "Mozilla/17.0");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		
		ArrayList<String> response = new ArrayList<String>();
		
		while((inputLine = in.readLine()) != null) {
			response.add(inputLine);
		}
		in.close();
		
		String[] number = response.get(12).split(":");
		double num = Double.parseDouble(number[1]);
		System.out.println(num);
		if (num >= 0.8)
		{
			return true;
		}
		return false;

	}
}
