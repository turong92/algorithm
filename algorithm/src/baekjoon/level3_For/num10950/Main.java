package baekjoon.level3.num10950;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] arr = new int[cnt];
		
		for(int i=0;i<cnt;i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			arr[i] = first + second;
		}
		
		for(int i=0;i<cnt;i++) {
			System.out.println(arr[i]);
		}
		
		sc.close();
	}

}
