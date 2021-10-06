package goorm.level1.num49088;

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double N1 = Double.parseDouble(st.nextToken());
		double N2 = Double.parseDouble(st.nextToken());
		double D = Double.parseDouble(br.readLine());
		
		for(int i=1; i<=D; i++){
			if(i % 2 == 1){
				double num = Math.round(N1 / 2);
				N1 -= num;
				N2 += num;
			}else {
				double num = Math.round(N2 / 2);
				N1 += num;
				N2 -= num;
			}
		}
		
		System.out.println((int) N1 + " " + (int) N2);
	}
}