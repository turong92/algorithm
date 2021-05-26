package backjoon.level1.num10430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		int third = Integer.parseInt(st.nextToken());
		System.out.println((first + second) % third);
		System.out.println(((first % third) + (second % third)) % third);
		System.out.println(first * second % third);
		System.out.println(((first % third) * (second % third)) % third);
	}

}
