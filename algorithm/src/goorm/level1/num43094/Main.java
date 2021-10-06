package goorm.level1.num43094;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double avg = (Double.parseDouble(st.nextToken())
			+ Double.parseDouble(st.nextToken())
			+ Double.parseDouble(st.nextToken()))
			/ 3;
		
		String grade;
		if(90 <= avg) grade = "A";
		else if(80 <= avg) grade = "B";
		else if(70 <= avg) grade = "C";
		else if(60 <= avg) grade = "D";
		else grade = "F";
		
		System.out.println(new DecimalFormat("0.00").format(avg) + " " + grade);
	}
}