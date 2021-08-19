package baekjoon.level14.num9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] cols;
	static int cnt = 0;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cols = new int[N];
		
		dfs(0);
		System.out.println(cnt);
		
		br.close();
	}
	
	public static void dfs(int idx) {
		if(idx == N) {
			cnt++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			cols[idx] = i;
			
			if(check(idx)) {
				dfs(idx+1);
			}
		}
	}
	
	public static boolean check(int col) {
		for(int i=0;i<col;i++) {
			if(cols[col] == cols[i]) return false;
			else if(Math.abs(col-i) == Math.abs(cols[col]-cols[i])) return false;
		}
		return true;
	}
}

/*
N-Queen
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
10 초	128 MB	44948	23496	15385	51.647%
문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

예제 입력 1 
8
예제 출력 1 
92
*/