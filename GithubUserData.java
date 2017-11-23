import java.io.BufferedReader;

// Get API Login, then has access to current user, use data to present 

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class GithubUserData {
	public static void main(String[] args) throws Exception {
		
		System.out.print("Enter username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.next();
		scanner.close();
		String url = "https://api.github.com/users/" + username;
		
		System.out.println(url);

		//Create HttpURLConnection 
		HttpURLConnection httpcon = (HttpURLConnection) new URL(url).openConnection();
		httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
		BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));

		//Read line by line
		StringBuilder responseSB = new StringBuilder();
		String line;
		while ( ( line = in.readLine() ) != null) {
			responseSB.append("\n" + line);
		}
		in.close();
		
		String data = responseSB.toString();
		String[] data2;
		data2 = data.split(",");
		for (int i = 0;i<data2.length; i++) {
			if(data2[i].contains("_url")) {
				System.out.println("-----");
			}
			else {
				System.out.println(data2[i]);
			}
		}
		
	}
}
	