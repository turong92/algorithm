package baekjoon.level15.num1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] colorCost;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		colorCost = new int[N][3];
		dp = new int[N][3];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			colorCost[i][0] = Integer.parseInt(st.nextToken());
			colorCost[i][1] = Integer.parseInt(st.nextToken());
			colorCost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = colorCost[0][0];
		dp[0][1] = colorCost[0][1];
		dp[0][2] = colorCost[0][2];
		
		System.out.println(Math.min(paint(N - 1, 0), Math.min(paint(N - 1, 1), paint(N - 1, 2))));
		
		br.close();
	}
	
	public static int paint(int idx, int color) {
		if(dp[idx][color] == 0) {
			if(color == 0) {
				dp[idx][0] = Math.min(paint(idx - 1, 1), paint(idx - 1, 2)) + colorCost[idx][0];
			}else if(color == 1) {
				dp[idx][1] = Math.min(paint(idx - 1, 0), paint(idx - 1, 2)) + colorCost[idx][1];
			}else if(color == 2) {
				dp[idx][2] = Math.min(paint(idx - 1, 0), paint(idx - 1, 1)) + colorCost[idx][2];
			}
		}
		
		return dp[idx][color];
	}

}

/*
문제
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

예제 입력 1 
3
26 40 83
49 60 57
13 89 99
예제 출력 1 
96
*/