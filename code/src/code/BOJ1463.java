package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.RecursiveAction;

public class BOJ1463 {


	public static void main(String[] args) throws IOException {
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       int number = Integer.parseInt(br.readLine());
	       int dp[] = new int[number+1];
		
	       //예외의 경우 
	       dp[0] = 0;
	       dp[1] = 0;
	       

	       //bottom-up
	       
	       for(int i=2;i<=number;i++) {
	    	   
	    	   dp[i] = dp[i-1]+1;
	    	   
	    	   if(i%2 == 0) {
	    		   dp[i] = Math.min(dp[i-1]+1,dp[i/2]+1);
	    	   }
	    	   
	    	   if(i%3 == 0) {
	    		   dp[i] = Math.min(dp[i-1]+1,dp[i/3]+1);
	    	   }
	    	   
	    	   
	    	   
	       }
	       
	       int result = dp[number];
	       //int result = recursive(number);
	       
	       //System.out.print(dp[number]);
	       System.out.print(result);
	       br.close();
	}
	
	//top-down : recursive 하게 
	public static int recursive(int number) {
		int dp[] = new int[number+1];
		
		if(number == 1) {
			return 0;
		}
		
		dp[number] = recursive(number-1)+1;
		
		if(number % 2 == 0) {
			int save = recursive(number/2)+1;
			if(save < dp[number]) {
				dp[number] = save;
			}
		}
		
		if(number % 3 == 0) {
			int save = recursive(number/3)+1;
			if(save < dp[number]) {
				dp[number] = save;
			}
		}
		
		
		return dp[number];
		
	}
	

}
