package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ11659 {
	public void bj11659() throws IOException{
		
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferReader.readLine());
		int numCnt = Integer.parseInt(stringTokenizer.nextToken()); 
		int qstCnt = Integer.parseInt(stringTokenizer.nextToken());
		
		long[] S = new long[numCnt + 1];
		
		
		stringTokenizer = new StringTokenizer(bufferReader.readLine());
		//  숫자 개수 만큼 반복해서 완성된 합배열 생성 
		for(int i=1; i<numCnt+1; i++) {
			S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
		}
		
		//질의 개수 만큼 반복
			// 질의 범위 받기 
			// 범위의구간한 구하기 
	for(int q=0; q<qstCnt; q++) {
		stringTokenizer = new StringTokenizer(bufferReader.readLine());
		int start = Integer.parseInt(stringTokenizer.nextToken());
		int end = Integer.parseInt(stringTokenizer.nextToken());
		
		System.out.println(S[end] - S[start-1]);
		}
		
	}
}