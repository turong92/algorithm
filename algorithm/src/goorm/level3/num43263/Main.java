package goorm.level3.num43263;
//level.goorm.io/exam/43263/특정-구간의-합/quiz/1

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int result = 0;
		for(int i=start-1; i<end; i++){
			result += nums[i];
		}
		
		System.out.print(result);
	}
}