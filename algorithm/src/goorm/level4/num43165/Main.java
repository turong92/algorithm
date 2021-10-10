package goorm.level4.num43165;
//https://level.goorm.io/exam/43165/%ED%83%80%EC%9D%BC-%EC%B1%84%EC%9A%B0%EA%B8%B0/quiz/1
//구름LEVEL 길찾기(다이아몬드)

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//가로의 길이
		int len = Integer.parseInt(br.readLine());
		//다이아몬드의 높이
		int row = 2 * len - 1;
		//숫자를 담을 배열 선언(다이아몬드)
		int[][] nums = new int[row][];
		//숫자의 합을 담을 배열 선언
		int[][] dp = new int[row][];
		
		for(int i=0; i<row; i++){
			//다이아몬드 높이만큼 반복하며 각 가로 길이만큼 배열에 값을 넣는다.
			nums[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//dp 배열도 다이아몬드 높이별 가로만큼 선언
			dp[i] = new int[nums[i].length];
		}
		//마지막 열 초기화
		dp[row - 1] = nums[row - 1];
		
		System.out.print(search(nums, dp, 0, 0, len));
		
	}
	
	public static int search(int[][] nums, int[][] dp, int depth, int col, int len){
		/*
		 * nums : 숫자가 저장된 다이아몬드 배열 
		 * dp : 합이 저장될 배열
		 * depth : 현재 세로 index
		 * col : 현재 가로 index 
		 * len : 최대 가로의 길이
		 */
		
		//배열을 벗어나면
		if(col < 0 || nums[depth].length <= col)
			return 0;
		
		//dp 배열에 값이 있을 경우
		if(dp[depth][col] != 0)
			return dp[depth][col];
			
		//증가하는 구간일 경우 (최대 가로길이의 값보다 깊이가 낮으면 증가하는 구간)
		if(depth < len - 1){
			//좌, 우 값 중에서 큰값을 구해 현재값과 더함 (증가하는 구간이므로 col, col+1)
			dp[depth][col] = Math.max(search(nums, dp, depth + 1, col, len),
					search(nums, dp, depth + 1, col + 1, len)) + 
					nums[depth][col];
		}else {
			//좌, 우 값 중에서 큰값을 구해 현재값과 더함 (감소하는 구간이므로 col-1, col)
			dp[depth][col] = Math.max(search(nums, dp, depth + 1, col - 1, len),
					search(nums, dp, depth + 1, col, len)) + 
					nums[depth][col];
		}
		return dp[depth][col];
	}
}