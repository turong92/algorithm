package baekjoon.level11.num1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int cnt = 1;
		
		while(cnt != N) {
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(num);
		
		br.close();
	}
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		int quotient = N / 19;
//		int remainder = N % 19;
//		
//		StringBuilder sb = new StringBuilder();
//		
//		if(remainder <= 6) {
//			int front = (quotient * 10) + (remainder - 1);
//			if(front != 0) {
//				sb.append(front);
//			}
//			sb.append("666");
//		}else if(6 < remainder && remainder <= 16) {
//			if(quotient != 0) {
//				sb.append(quotient);
//			}
//			sb.append("666");
//			sb.append((remainder - 7));
//		}else if(16 < remainder) {
//			if(quotient != 0) {
//				sb.append(quotient);
//			}
//			sb.append((remainder - 10));
//			sb.append("666");
//		}
//		
//		System.out.println(sb);
//		
//		br.close();
//	}
//
//}

/*
문제
666은 종말을 나타내는 숫자라고 한다. 따라서, 많은 블록버스터 영화에서는 666이 들어간 제목을 많이 사용한다. 영화감독 숌은 세상의 종말 이라는 시리즈 영화의 감독이다. 조지 루카스는 스타워즈를 만들 때, 스타워즈 1, 스타워즈 2, 스타워즈 3, 스타워즈 4, 스타워즈 5, 스타워즈 6과 같이 이름을 지었고, 피터 잭슨은 반지의 제왕을 만들 때, 반지의 제왕 1, 반지의 제왕 2, 반지의 제왕 3과 같이 영화 제목을 지었다.

하지만 숌은 자신이 조지 루카스와 피터 잭슨을 뛰어넘는다는 것을 보여주기 위해서 영화 제목을 좀 다르게 만들기로 했다.

종말의 숫자란 어떤 수에 6이 적어도 3개이상 연속으로 들어가는 수를 말한다. 제일 작은 종말의 숫자는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 과 같다.

따라서, 숌은 첫 번째 영화의 제목은 세상의 종말 666, 두 번째 영화의 제목은 세상의 종말 1666 이렇게 이름을 지을 것이다. 일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 숫자) 와 같다.

숌이 만든 N번째 영화의 제목에 들어간 숫자를 출력하는 프로그램을 작성하시오. 숌은 이 시리즈를 항상 차례대로 만들고, 다른 영화는 만들지 않는다.

입력
첫째 줄에 숫자 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 N번째 영화의 제목에 들어간 수를 출력한다.

예제 입력 1 
2
예제 출력 1 
1666


666	1
1666 	2
2666	3
3666	4
4666	5
5666	6

6660	7
6661	8
6662	9
6663	10
6664	11
6665	12
6666	13
6667	14
6668	15
6669	16

7666	17
8666	18
9666	19

10666	20
11666	21
12666	22
13666	23
14666	24
15666	25

16660	26
16661	27
16662	28
16663	29
16664	30
16665	31
16666	32
16667	33
16668	34
16669	35

17666	36
18666	37
19666	38

20666	39
21666	40


121에서 문제 66600 이어야되는데 66660
*/