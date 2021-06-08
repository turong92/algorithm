package baekjoon.level4.num10952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			if(first==0 && second==0) break;
			
			sb.append(first + second).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}

}

/*
입력
1 1
2 3
3 4
9 8
5 2
0 0

출력
2
5
7
17
7
*/

