package baekjoon.level12.num2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cntMinus = new int[4001];
		int[] cntPlus = new int[4001];
		int modeCnt = 0;
		
		Stack<Integer> st = new Stack<>();

		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num < 0) {
				cntMinus[Math.abs(num)]++;
			}else {
				cntPlus[num]++;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=4000;0<i;i--) {
			if(modeCnt < cntMinus[i]) {
				// 최빈값이 갱신되면
				modeCnt = cntMinus[i];
				st.clear();
				st.push((-1)*i);
				//stack을 비우고 최빈값 추가(minus 끝부터 시작이므로 최저값 저장)
			}else if(modeCnt == cntMinus[i] && st.size() < 2) {
				//같은 최빈값이 등장했을 때 두번째로 작은 최빈값이 없으면
				st.push((-1)*i);
			}
			while(0 < cntMinus[i]) {
				list.add((-1)*i);
				cntMinus[i]--;
			}
		}
		
		for(int i=0;i<4001;i++) {
			if(modeCnt < cntPlus[i]) {
				// 최빈값이 갱신되면
				modeCnt = cntPlus[i];
				st.clear();
				st.push(i);
				//stack을 비우고 최빈값 추가(0 부터 시작이므로 최저값 저장)
			}else if(modeCnt == cntPlus[i] && st.size() < 2) {
				//같은 최빈값이 등장했을 때 두번째로 작은 최빈값이 없으면
					st.push(i);
			}
			while(0 < cntPlus[i]) {
				list.add(i);
				cntPlus[i]--;
			}
		}
		
		System.out.println(getAvg(list));
		System.out.println(list.get(N/2));
		System.out.println(st.peek());
		System.out.println(Math.abs(list.get(list.size()-1) - list.get(0)));
		
		br.close();
	}
	
	public static int getAvg(ArrayList<Integer> list) {
		double result = 0.0;
		for(int i=0;i<list.size();i++) {
			result += list.get(i);
		}
		result /= list.size();
		
		return (int) Math.round(result);
	}
	

}

/*
문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.

예제 입력 1 
5
1
3
8
-2
2
예제 출력 1 
2
2
1
10
예제 입력 2 
1
4000
예제 출력 2 
4000
4000
4000
0
예제 입력 3 
5
-1
-2
-3
-1
-2
예제 출력 3 
-2
-2
-1
2
*/