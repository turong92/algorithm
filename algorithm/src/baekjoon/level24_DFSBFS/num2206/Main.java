package baekjoon.level24_DFSBFS.num2206;

import java.io.*;
import java.util.*;

public class Main {
	static class point{
		int y;
		int x;
		boolean isCrashed;
		int cnt;
		
		point(int y, int x, boolean isCrashed, int cnt){
			this.y = y;
			this.x = x;
			this.isCrashed = isCrashed;
			this.cnt = cnt;
		}
	}
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][][] isVisited = new boolean[N][M][2];
		
		for(int i=0; i<N; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		System.out.println(bfs(map, isVisited, N, M));
	}
	
	public static int bfs(int[][] map, boolean[][][] isVisited, int N, int M) {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(0, 0, false, 1));
		
		while(!q.isEmpty()) {
			point cur = q.poll();
			
			if(cur.y == N - 1 && cur.x == M - 1) {
				return cur.cnt;
			}
			
			for(int i=0; i<4; i++) {
				int nextY = cur.y + dy[i];
				int nextX = cur.x + dx[i];
				
				if(0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
					if(map[nextY][nextX] == 0) {
						if(!isVisited[nextY][nextX][0] && !cur.isCrashed) {
							q.add(new point(nextY, nextX, cur.isCrashed, cur.cnt + 1));
							isVisited[nextY][nextX][0] = true;
						}else if(!isVisited[nextY][nextX][1] && cur.isCrashed) {
							q.add(new point(nextY, nextX, cur.isCrashed, cur.cnt + 1));
							isVisited[nextY][nextX][1] = true;
						}
					}else if(map[nextY][nextX] == 1) {
						if(!cur.isCrashed) {
							q.add(new point(nextY, nextX, true, cur.cnt + 1));
							isVisited[nextY][nextX][1] = true;
						}
					}
				}
			}
		}
		
		return -1;
	}

}

/*
https://www.acmicpc.net/problem/2206

벽 부수고 이동하기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	192 MB	68201	17108	10536	22.724%
문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.

한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

출력
첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.

예제 입력 1 
6 4
0100
1110
1000
0000
0111
0000
예제 출력 1 
15
예제 입력 2 
4 4
0111
1111
1111
1110
예제 출력 2 
-1
*/