package goorm.level1.num49087;

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double[] x = new double[3];
		double[] y = new double[3];
		
		for(int i=0; i<3; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Double.parseDouble(st.nextToken());
			y[i] = Double.parseDouble(st.nextToken());
		}
		
		double S = Math.abs(
			(x[0]*y[1] + x[1]*y[2] + x[2]*y[0]) 
			- (x[1]*y[0] + x[2]*y[1] + x[0]*y[2])
		) / 2;
		
		System.out.printf("%.2f", S);
	}
}

//S = abs((x1y2 + x2y3 + x3y1) - (x2y1 + x3y2 + x1y3)) / 2
