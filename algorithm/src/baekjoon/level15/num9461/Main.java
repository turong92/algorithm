package baekjoon.level15.num9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long[] P = new Long[101];
		int T = Integer.parseInt(br.readLine());
		
		P[1] = 1L;
		P[2] = 1L;
		P[3] = 1L;
		
		for(int i=4;i<101;i++) {
			P[i] = P[i-2] + P[i-3];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(P[N]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}

}

/*
파도반 수열 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	50328	21395	17602	41.108%
문제
오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다. 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.

파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.

N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)

출력
각 테스트 케이스마다 P(N)을 출력한다.

예제 입력 1 
2
6
12
예제 출력 1 
3
16
*/