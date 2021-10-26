package baekjoon.level12.num18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		int[] pointArr = new int[N];
		
		for(int i=0;i<strArr.length;i++) {
			pointArr[i] = Integer.parseInt(strArr[i]);
		}
		
		int[] sortedPointArr = pointArr.clone();
		Arrays.sort(sortedPointArr);
		
		int cnt = 0;
		HashMap<Integer, Integer> hash = new HashMap<>();
		for(int i=0;i<sortedPointArr.length;i++) {
			if(!hash.containsKey(sortedPointArr[i])) {
				hash.put(sortedPointArr[i], cnt++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<pointArr.length;i++) {
			sb.append(hash.get(pointArr[i])).append(" ");
		}
		
		System.out.println(sb);
		
		br.close();
	}

}

/*
좌표 압축
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	12281	5661	4230	44.786%
문제
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

입력
첫째 줄에 N이 주어진다.

둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

출력
첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

제한
1 ≤ N ≤ 1,000,000
-109 ≤ Xi ≤ 109
예제 입력 1 
5
2 4 -10 4 -9
예제 출력 1 
2 3 0 3 1
예제 입력 2 
6
1000 999 1000 999 1000 999
예제 출력 2 
1 0 1 0 1 0
*/