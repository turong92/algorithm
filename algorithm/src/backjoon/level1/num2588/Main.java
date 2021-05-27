package backjoon.level1.num2588;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		//StringTokenizer st2 = new StringTokenizer(br.readLine(), "");
		String[] strArr1 = sc.next().split("");
		String[] strArr2 = sc.next().split("");
		int[] numArr1 = new int[strArr1.length];
		int[] numArr2 = new int[strArr2.length];
		
		for(int i=0;i<strArr1.length;i++) {
			numArr1[i] = Integer.parseInt(strArr1[i]);
		}
		
		for(int i=0;i<strArr2.length;i++) {
			numArr2[i] = Integer.parseInt(strArr2[i]);
		}
		
		int result = 0;
		for(int i=numArr2.length-1;0<=i;i--) {
			int mult = 0;
			for(int j=numArr1.length-1;0<=j;j--) {
				mult += numArr1[j] * numArr2[i] * Math.pow(10, numArr1.length-1-j);
			}
			result += mult * Math.pow(10, numArr2.length-1-i);
			System.out.println(mult);
		}
		System.out.println(result);
	}

}
