package backjoon.level2.num2884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		
		int diff = minute - 45;
		if(diff < 0) {
			if(hour == 0) hour = 24;
			hour--;
			minute = 60 + diff;
		}else minute = diff;
		
		System.out.println(hour + " " + minute);
		
		sc.close();
	}

}
