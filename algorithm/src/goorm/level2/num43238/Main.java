package goorm.level2.num43238;

import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		boolean[] isPrimeReverse = new boolean[A + 1];
		isPrimeReverse[0] = isPrimeReverse[1] = true;
		
		for(int i=2; i*i<=A; i++){
			for(int j=i*i; j<=A; j+=i)
				isPrimeReverse[j] = true;
		}
		
		if(isPrimeReverse[A]) System.out.print("False");
		else System.out.print("True");
	}
}