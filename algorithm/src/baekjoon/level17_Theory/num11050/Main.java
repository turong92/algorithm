package baekjoon.level17.num11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int result = factorial(N) / (factorial(K) * factorial(N - K));
		
		System.out.println(result);
		
		br.close();
	}
	
	public static int factorial(int n) {
		if(n <= 1) return 1;
		else return factorial(n - 1) * n;
	}

}

/*
이항 계수 1
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	24474	15760	13579	64.659%
문제
자연수 N과 정수 K가 주어졌을 때 이항 계수 
binom{N}{K}를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)

출력
 
binom{N}{K}를 출력한다.

예제 입력 1 
5 2
예제 출력 1 
10
*/