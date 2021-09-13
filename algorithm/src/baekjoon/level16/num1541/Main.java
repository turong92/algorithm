package baekjoon.level16.num1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
		
		int result = Integer.MAX_VALUE;
		while(minus.hasMoreTokens()) {
			int unit = 0;
			
			StringTokenizer st = new StringTokenizer(minus.nextToken(), "+");
			
			while(st.hasMoreTokens()) {
				unit += Integer.parseInt(st.nextToken());
			}
			
			if(result == Integer.MAX_VALUE) result = unit;
			else result -= unit;
		}
		
		System.out.println(result);
		
		br.close();
	}

}

/*
잃어버린 괄호
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	33413	15742	12721	47.117%
문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

출력
첫째 줄에 정답을 출력한다.

예제 입력 1 
55-50+40
예제 출력 1 
-35
*/