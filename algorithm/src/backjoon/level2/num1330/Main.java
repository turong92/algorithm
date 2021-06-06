package backjoon.level2.num1330;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int second = sc.nextInt();
		
		if(first < second) {
			System.out.println("<");
		}else if(first == second) {
			System.out.println("==");
		}else {
			System.out.println(">");
		}
		sc.close();
	}
}
