package baekjoon.level5.num10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		int min = Integer.parseInt(strArr[0]);
		int max = Integer.parseInt(strArr[0]);
		
		for(int i=1;i<len;i++) {
			int num = Integer.parseInt(strArr[i]);
			if(num < min) min = num;
			if(max < num) max = num;
		}
		
		System.out.println(min + " " + max);
		
		br.close();
	}

}

/*
입력
5
20 10 35 30 7

출력
7 35
*/