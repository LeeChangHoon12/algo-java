package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		int index = 0;
		
		while(stringTokenizer.hasMoreTokens()) {
			arr[index] = Integer.parseInt(stringTokenizer.nextToken());
			index++;
		}
			
		Arrays.sort(arr);

		
		int left = 0; //배열 좌측 포인터 
		int right = N-1; //배열 우측 포인터 
		int count = 0; 
		
		while(left < right) {			
			if(arr[left] + arr[right] == M) {
				count++;
				right--;
				left++;
			}
			else if(arr[left] + arr[right] > M){
				right--;
			}
			else if(arr[left] + arr[right] < M) {
				left++;
			}
			
		}
		
		System.out.println(count);
		
		
		

	}

}
