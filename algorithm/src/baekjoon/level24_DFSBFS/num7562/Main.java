package baekjoon.level24_DFSBFS.num7562;

import java.io.*;
import java.util.*;

public class Main {
	static class point{
		int y;
		int x;
		int cnt;
		
		point(int y, int x, int cnt){
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine()); 
		
		StringTokenizer st;
		while(loop-- > 0) {
			int len = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int destX = Integer.parseInt(st.nextToken());
			int destY = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[len][len];
			boolean[][] isVisited = new boolean[len][len];
			bfs(board, isVisited, len, y, x, destY, destX);
		}
	}
	
	public static void bfs(int[][] board, boolean[][] isVisited, int len, int y, int x, int destY, int destX) {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(y, x, 0));
		isVisited[y][x] = true;
		
		while(!q.isEmpty()) {
			point cur = q.poll();
			
			if(cur.y == destY && cur.x == destX) {
				System.out.println(cur.cnt);
				return;
			}
			
			for(int i=0; i<8; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(ny < 0 || nx < 0 || len <= ny || len <= nx)	continue;
				
				if(!isVisited[ny][nx]) {
					q.offer(new point(ny, nx, cur.cnt + 1));
					isVisited[ny][nx] = true;
				}
			}
		}
		
		System.out.println(-1);
	}

}

/*
https://www.acmicpc.net/problem/7562

나이트의 이동 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	29832	14498	10853	47.643%
문제
체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?



입력
입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

출력
각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.

예제 입력 1 
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
예제 출력 1 
5
28
0
*/