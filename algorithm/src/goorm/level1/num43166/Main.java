package goorm.level1.num43166;

import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		for(int i=3; i<=N; i++)
			if(i % 3 == 0 || i % 5 == 0) result += i;
		
		System.out.println(result);
	}
}