package baekjoon.level15.num10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static Long[][] dp;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new Long[N+1][10];
		
		for(int i=0;i<=N;i++) {
			Arrays.fill(dp[i], -1L);
		}
		
		for(int i=0;i<10;i++) {
			dp[1][i] = 1L;
		}
		
		long result = 0;
		
		for(int i=1;i<=9;i++) {
			result += cal(N, i);
		}
		
		System.out.println(result % 1000000000);
		
		br.close();
	}
	
	public static long cal(int depth, int idx) {
		if(depth == 1) return dp[depth][idx];
		
		if(dp[depth][idx] == -1) {
			if(idx == 0) dp[depth][idx] = cal(depth - 1, 1);
			else if(idx == 9) dp[depth][idx] = cal(depth - 1, 8);
			else dp[depth][idx] = cal(depth - 1, idx - 1) + cal(depth - 1, idx + 1);
		}
		
		return dp[depth][idx] % 1000000000;
	}

}

/*
쉬운 계단 수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	85849	26362	18906	28.764%
문제
45656이란 수를 보자.

이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.

예제 입력 1 
1
예제 출력 1 
9
예제 입력 2 
2
예제 출력 2 
17
*/

/*
1
1	2	3	4	5	6	7	8	9

2
10	12	21	23	32	34	43	45	54	56	65	67	76	78	87	89	98

3
101	121	123	
*/