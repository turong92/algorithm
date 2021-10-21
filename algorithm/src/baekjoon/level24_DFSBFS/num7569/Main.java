package baekjoon.level24_DFSBFS.num7569;

import java.io.*;
import java.util.*;

public class Main {
	static class point{
		int h;
		int y;
		int x;
		
		point(int h, int y, int x){
			this.h = h;
			this.y = y;
			this.x = x;
		}
	}
	
	static int[] dh = {1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] box = new int[H][N][M];
		boolean[][][] isVisited = new boolean[H][N][M];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs(box, isVisited, H, N, M);
	}
	
	public static void bfs(int[][][] box, boolean[][][] isVisited, int H, int N, int M) {
		Queue<point> q = new LinkedList<>();
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(box[i][j][k] == 1) q.offer(new point(i, j, k));
				}
			}
		}
		
		while(!q.isEmpty()) {
			point cur = q.poll();
			
			for(int i=0; i<2; i++) {
				int nextH = cur.h + dh[i];
				if(0 <= nextH && nextH < H) {
					if(!isVisited[nextH][cur.y][cur.x] && box[nextH][cur.y][cur.x] == 0) {
						box[nextH][cur.y][cur.x] = box[cur.h][cur.y][cur.x] + 1;
						q.add(new point(nextH, cur.y, cur.x));
						isVisited[nextH][cur.y][cur.x] = true;
					}
				}
			}
			
			for(int i=0; i<4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				
				if(0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
					if(!isVisited[cur.h][nextY][nextX] && box[cur.h][nextY][nextX] == 0) {
						box[cur.h][nextY][nextX] = box[cur.h][cur.y][cur.x] + 1;
						q.add(new point(cur.h, nextY, nextX));
						isVisited[cur.h][nextY][nextX] = true;
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(box[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					
					max = Math.max(max, box[i][j][k]);
				}
			}
		}
		
		System.out.println(max - 1);
	}

}

/*
https://www.acmicpc.net/problem/7569

토마토 출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	39043	15347	11215	40.644%
문제
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.



창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

입력
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다. 둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다. 각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 이러한 N개의 줄이 H번 반복하여 주어진다.

토마토가 하나 이상 있는 경우만 입력으로 주어진다.

출력
여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

예제 입력 1 
5 3 1
0 -1 0 0 0
-1 -1 0 1 1
0 0 0 1 1
예제 출력 1 
-1
예제 입력 2 
5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
예제 출력 2 
4
예제 입력 3 
4 3 2
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
-1 -1 -1 -1
1 1 1 -1
예제 출력 3 
0
*/