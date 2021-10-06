package goorm.level1.num43255;

import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++){
			if(N % i == 0){
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}