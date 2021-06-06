package backjoon.level3.num11022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int standard =  Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<len;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num < standard) {
				sb.append(num).append(" ");
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}

}

//입력
//10 5
//1 10 4 9 2 3 8 5 7 6
//출력
//1 4 2 3