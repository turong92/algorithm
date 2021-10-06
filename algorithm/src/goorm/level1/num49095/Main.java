package goorm.level1.num49095;

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int result = 1;
		int before = Integer.parseInt(st.nextToken());
		while(st.hasMoreTokens()){
			int cur = Integer.parseInt(st.nextToken());
			if(c < (cur - before)) result = 0;
			before = cur;
			result++;
		}
		
		System.out.print(result);
	}
}