package baekjoon.other.num3671;
//https://www.acmicpc.net/problem/3671

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		for(int i=0; i<c; i++) {
			System.out.println(calCnt(br.readLine()));
		}
	}
	
	public static int calCnt(String numStr) {
		boolean[] isVisited = new boolean[numStr.length()];
		HashSet<Integer> permutationSet = new HashSet<>();
		permutation(numStr, isVisited, permutationSet, "");
		
		return permutationSet.size();
	}
	
	public static void permutation(String numStr, boolean[] isVisited, HashSet<Integer> permutationSet, String permutationStr) {	
		for(int i=0; i<numStr.length(); i++) {
			if(isVisited[i]) continue;
			String temp = permutationStr + numStr.charAt(i);
			isVisited[i] = true;
			int num = Integer.parseInt(temp);
			if(isPrime(num)) permutationSet.add(num);
			permutation(numStr, isVisited, permutationSet, temp);
			isVisited[i] = false;
		}
	}
	
	public static boolean isPrime(int num) {
		if(num < 2) return false;

		for(int i=2; i*i<=num; i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}
	
//	public static boolean[] makePrimeArr(int size) {
//		boolean[] isPrime = new boolean[size + 1];
//		isPrime[0] = true;
//		if(0 < size) isPrime[1] = true;
//		for(int i=2; i*i<=size; i++) {
//			if(!isPrime[i]) {
//				for(int j=i*i; j<=size; j+=i) {
//					isPrime[j] = true;
//				}
//			}
//		}
//
//		return isPrime;
//	}
	
}




/*
산업 스파이의 편지 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1.5 초	128 MB	1300	610	443	48.257%
문제
안녕하세요. 저는 산업 스파이입니다. 저의 정체를 절대 다른 사람에게 말하지 말아주세요.

저의 가장 최근 일은 유명한 수학 연구소의 최신 연구 결과를 훔쳐오는 것이었습니다. 저는 매우 유능한 산업 스파이이기 때문에, 연구 결과를 어렵지 않게 얻을 수 있었습니다. 하지만, 제가 올 것을 미리 알았는지 연구소에서는 연구 결과를 모두 서류 절단기에 넣어버렸습니다. 어쩔수 없이 저는 눈물을 머금고 종이 조각을 모두 훔쳐왔습니다.

저를 고용한 사람은 매우 무서운 사람입니다. 또, 저는 프로이기 때문에 실수를 용납하지 않습니다. 어떻게든 이 종이를 모두 복구해가야합니다. 이 연구소의 연구 주제는 빠른 소인수 분해입니다. 제가 가진 종이 조각에는 숫자가 한 자리씩만 적혀져 있습니다. 원래 숫자가 뭐였는지를 잘 모르겠습니다. 종이 조각에 쓰여 있는 숫자를 보내드릴테니, 종이 조각을 적절히 배치해서 소수가 되는 경우가 몇 개이지 알려주실 수 있나요?

감사합니다.

스파이 드림.

입력
첫째 줄에 테스트 케이스의 개수 c가 주어진다. (1 ≤ c ≤ 200) 각 테스트 케이스는 한 줄로 이루어져 있고, 종이조각에 쓰여 있는 수가 공백없이 주어진다. 종이조각의 수는 적어도 1개, 많아야 7개이다.

출력
각 테스트 케이스에 대해 종이조각을 적절히 배치해서 만들 수 있는 서로 다른 소수의 개수를 출력한다. 이때, 모든 종이 조각을 사용하지 않아도 된다. (7과 1이 있을 때, 만들 수 있는 소수는 7, 17, 71이다) 종이 조각을 적절히 배치해서 만든 숫자가 0으로 시작할 때, 앞에있는 0을 지운 수가 같으면 같은 숫자이다.

예제 입력 1 
4
17
1276543
9999999
011
예제 출력 1 
3
1336
0
2
*/