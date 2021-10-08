package goorm.level3.num43064;
//https://level.goorm.io/exam/43064/binary-search/quiz/1

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int T = Integer.parseInt(br.readLine());
		System.out.print(search(nums, T));
	}
	
	public static String search(int[] arr, int target){
		int low = 0;
		int high = arr.length - 1;
		int middle;
		
		while(low <= high){
			middle = (low + high) / 2;
			if(arr[middle] == target){
				return Integer.toString(middle + 1);
			}else if(arr[middle] < target){
				low = middle + 1;
			}else if(target < arr[middle]){
				high = middle - 1;
			}
		}
		
		return "X";
	}
}