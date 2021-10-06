package goorm.level1.num48757;

import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		for(int i=1; i<N; i++){
			int num = i;
			while(0 < num){
				int remain = num % 10;
				if(remain != 0 && remain % 3 == 0) {
					result++;
				}
				num /= 10;
			}
		}
		System.out.print(result);
	}
}