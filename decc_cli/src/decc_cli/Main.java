package decc_cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
	
	public static void main(String [] a){
		String name = "decccli";
		if(a.length > 0)
			name = a[0];
			
		DeccUser decc = new DeccUser(name);
	
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				decc.stop();
			}
		}));
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		try {
			while(!(line = reader.readLine()).equals("quit")){
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			decc.stop();
		}
		
		
	}
}
