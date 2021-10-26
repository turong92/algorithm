package baekjoon.level24_DFSBFS.num2178;

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
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][M];
		boolean[][] isVisited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		System.out.println(bfs(maze, isVisited));
	}
	
	public static int bfs(int[][] maze, boolean[][] isVisited) {
		int N = maze.length;
		int M = maze[0].length;
		
		Queue<point> q = new LinkedList<>();
		q.add(new point(0, 0, 1));
		isVisited[0][0] = true;
		
		while(!q.isEmpty()) {
			point cur = q.poll();
			if(cur.y == N - 1 && cur.x == M - 1) return cur.cnt;
			
			for(int i=0; i<4; i++) {
				int nextY = cur.y + dy[i];
				int nextX = cur.x + dx[i];
				
				if(0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
					if(!isVisited[nextY][nextX] && maze[nextY][nextX] == 1) {
						q.offer(new point(nextY, nextX, cur.cnt + 1));
						isVisited[nextY][nextX] = true;
					}
				}
			}
		}
		return 0;
	}

}

/*
https://www.acmicpc.net/problem/2178

미로 탐색
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	192 MB	103085	42010	26816	39.354%
문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1 
4 6
101111
101010
101011
111011
예제 출력 1 
15
예제 입력 2 
4 6
110110
110110
111111
111101
예제 출력 2 
9
예제 입력 3 
2 25
1011101110111011101110111
1110111011101110111011101
예제 출력 3 
38
예제 입력 4 
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
예제 출력 4 
13
*/