package baekjoon.level4.num1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String standard = br.readLine();
		String result = standard;
		int cnt = 0;

		while(true) {
			StringBuilder sbNum = new StringBuilder(result);
			if(sbNum.length()<2) sbNum.insert(0, "0");
			char secondNum = sbNum.charAt(1);
			StringBuilder addNum = new StringBuilder(Integer.toString((sbNum.charAt(0) - '0') + (secondNum - '0')));
			StringBuilder tmp = new StringBuilder();
			if(secondNum != '0') tmp.append(secondNum);
			tmp.append(addNum.charAt(addNum.length()-1));
			result = tmp.toString();
			
			cnt++;
			if(standard.equals(result)) break;
		}
		
		System.out.println(cnt);
		
		br.close();
	}

}
