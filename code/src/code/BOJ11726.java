package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {

	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int dp[] = new int[1001]; //dp memorization 할 배열 
		int n = Integer.parseInt(br.readLine());  
		
		System.out.print(tailing(n,dp));
		
		


	}
	
	public static int tailing(int n,int dp[]) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		/*
		if(dp[n] == 0) {
			dp[n] = tailing(n-1,dp) + tailing(n-2,dp);
			return dp[n];
		}
		*/
		
		if(dp[n] != 0) {
			return dp[n];
		}
		
		return dp[n] = (tailing(n-1,dp) + tailing(n-2,dp)) % 10007;
	}

}
