package backjoon.level3.num2742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		
		for(int i=num;0<i;i--) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
