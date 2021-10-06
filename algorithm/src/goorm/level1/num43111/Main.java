package goorm.level1.num43111;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		if(input%2 == 1) System.out.println("odd");
		else System.out.println("even");
	}

}