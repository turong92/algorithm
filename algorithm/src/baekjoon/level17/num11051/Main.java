package baekjoon.level17.num11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] combs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		combs = new int[N + 1][K + 1];
		
		System.out.println(calCombs(N, K));
		
		br.close();
	}
	
	public static int calCombs(int n, int k) {
		if(combs[n][k] != 0) return combs[n][k];
		if(n == k || k == 0) return combs[n][k] = 1;
		return combs[n][k] = (calCombs(n - 1, k - 1) + calCombs(n - 1, k)) % 10007;
	}
}
/*
nCr = n-1Cr-1 + n-1Cr
*/

/*
이항 계수 2
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	31780	11929	9350	38.465%
문제
자연수 N과 정수 K가 주어졌을 때 이항 계수 
binom{N}{K}를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ K ≤ N)

출력
 
binom{N}{K}를 10,007로 나눈 나머지를 출력한다.

예제 입력 1 
5 2
예제 출력 1 
10
*/