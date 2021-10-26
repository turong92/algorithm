package baekjoon.level3.num11021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=num;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			sb.append("Case #").append(i).append(": ").append(first+second).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
