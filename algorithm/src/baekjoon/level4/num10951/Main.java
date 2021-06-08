package baekjoon.level4.num10951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "";
		StringTokenizer st;
		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
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

출력
2
5
7
17
7
*/