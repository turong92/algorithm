package goorm.level3.num43250;
//level.goorm.io/exam/43250/배열-합치기/quiz/1

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		br.readLine();
		arrayAdder(list, br.readLine());
		arrayAdder(list, br.readLine());
		
		Collections.sort(list, (s1, s2) -> {
			return s1 - s2;
		});
		
		StringBuilder sb = new StringBuilder();
		for(int n : list)
			sb.append(n).append(" ");
		
		System.out.print(sb);
	}
	
	public static void arrayAdder(List<Integer> list, String str){
		StringTokenizer st = new StringTokenizer(str);
		while(st.hasMoreTokens())
			list.add(Integer.parseInt(st.nextToken()));
	}
}