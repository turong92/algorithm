package baekjoon.level12.num1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = br.readLine().toCharArray();
		Arrays.sort(charArr);
		
		for(int i=charArr.length-1;0<=i;i--) {
			System.out.print(charArr[i]);
		}
		
		br.close();
	}
//	14232kb	124ms
}

/*
문제
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

입력
첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

예제 입력 1 
2143
예제 출력 1 
4321
*/

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = br.readLine().toCharArray();
		Arrays.sort(charArr);
		
		StringBuilder sb = new StringBuilder(new String(charArr));
		
		System.out.println(sb.reverse());
		
		br.close();
	}
//	14304kb	132ms
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = br.readLine().toCharArray();
		Arrays.sort(charArr);
		
		StringBuilder sb = new StringBuilder();
		
		for(Character ch : charArr) {
			sb.append(ch);
		}
		
		System.out.println(sb.reverse());
		
		br.close();
	}
//	14268kb	128ms
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split("");
		Arrays.sort(strArr);
		
		StringBuilder sb = new StringBuilder();
		
		for(String str : strArr) {
			sb.append(str);
		}
		
		System.out.println(sb.reverse());
		
		br.close();
	}
//	14380kb	124ms
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split("");
		Arrays.sort(strArr, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		
		for(String str : strArr) {
			sb.append(str);
		}
		
		System.out.println(sb);
		
		br.close();
	}
//	14284kb	132ms
}
*/
