package baekjoon.level17.num2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long cnt5 = calPowCnt(n, 5) - calPowCnt(n - m, 5) - calPowCnt(m, 5);
		long cnt2 = calPowCnt(n, 2) - calPowCnt(n - m, 2) - calPowCnt(m, 2);
		
		System.out.println(Math.min(cnt5, cnt2));
	}
	
	public static long calPowCnt(long num, int pow) {
		int cnt = 0;
		
		while(pow <= num) {
			cnt += num / pow;
			num /= pow;
		}
		
		return cnt;
	}

}

/*
 * nCm = n! / ((n - m)! * m!)
 */

/*
조합 0의 개수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	25873	7170	5965	29.027%
문제
 
n choose m의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 n, m (0 <= m <= n <= 2,000,000,000, n != 0)이 들어온다.

출력
첫째 줄에 
n choose m의 끝자리 0의 개수를 출력한다.

예제 입력 1 
25 12
예제 출력 1 
2
*/