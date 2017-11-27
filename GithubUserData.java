import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GithubUserData {
	public static void main(String[] args) throws Exception {
		
		System.out.print("Enter username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.next();
		scanner.close();
		String url = "https://api.github.com/users/" + username;
		
		System.out.println(url);

		//Connect to retrieve data
		HttpURLConnection httpcon = (HttpURLConnection) new URL(url).openConnection();
		httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
		BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));

		//Read in data
		StringBuilder jconData = new StringBuilder();
		String line;
		while ( ( line = in.readLine() ) != null) {
			jconData.append("\n" + line);
		}
		in.close();
		
		//Display data
		String data = jconData.toString();
		String[] data2;
		data2 = data.split(",");
		for (int i = 0;i<data2.length; i++) {
				System.out.println(data2[i]);
		}
	}
}
