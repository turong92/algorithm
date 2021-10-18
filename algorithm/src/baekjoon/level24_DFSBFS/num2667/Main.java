package baekjoon.level24_DFSBFS.num2667;

import java.io.*;
import java.util.*;

public class Main {
	
	static class point{
		int y;
		int x;
		
		point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] town = new int[N][];
		boolean[][] isVisited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			town[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(town[i][j] == 1 && !isVisited[i][j]) {
					bfs(town, i, j, isVisited, list);
				}
			}
		}
		
		Collections.sort(list, (o1, o2) -> {return o1 - o2;});
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void bfs(int[][] town, int y, int x, boolean[][] isVisited, ArrayList<Integer> list) {
		Queue<point> q = new LinkedList<>();
		int len = town.length;
		int cnt = 1;
		q.add(new point(y, x));
		isVisited[y][x] = true;
		
		point cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nextY = cur.y + dy[i];
				int nextX = cur.x + dx[i];
				
				if(0 <= nextY && nextY < len && 0 <= nextX && nextX < len) {
					if(!isVisited[nextY][nextX] && town[nextY][nextX] != 0) {
						q.add(new point(nextY, nextX));
						cnt++;
						isVisited[nextY][nextX] = true;
					}
				}
			}
		}
		
		list.add(cnt);
	}

}

/*
https://www.acmicpc.net/problem/2667

단지번호붙이기 출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	95893	40018	25224	39.754%
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.



입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

예제 입력 1 
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
예제 출력 1 
3
7
8
9
*/