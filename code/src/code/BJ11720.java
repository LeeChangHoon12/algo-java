package code;

import java.util.Scanner;

public class BJ11720 {
	public void bj11720() {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int SUM = 0;
		int tmp;
		
		String sNum = sc.next();
		

		for(int i = 0; i<sNum.length(); i++) {
			try {
			tmp = Integer.valueOf(sNum.charAt(i));
			System.out.println(tmp-'0');
			 SUM += tmp -'0';
				
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
			
		}
		
		System.out.println(SUM);
	}
	
}
