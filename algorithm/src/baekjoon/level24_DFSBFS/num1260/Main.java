package baekjoon.level24_DFSBFS.num1260;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		boolean[][] nodes = new boolean[N + 1][N + 1];
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			nodes[from][to] = true;
			nodes[to][from] = true;
		}
		
		boolean[] isVisited = new boolean[N + 1];
		
		DFS(nodes, V, isVisited);
		System.out.println();
		Arrays.fill(isVisited, false);
		BFS(nodes, V, isVisited);
	}
	
	public static void DFS(boolean[][] nodes, int cur, boolean[] isVisited) {
		isVisited[cur] = true;
		System.out.print(cur + " ");
		for(int i=1; i<nodes.length; i++) {
			if(nodes[cur][i] && !isVisited[i]) DFS(nodes, i, isVisited);
		}
	}
	
	public static void BFS(boolean[][] nodes, int cur, boolean[] isVisited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(cur);
		isVisited[cur] = true;
		
		while(!q.isEmpty()) {
			int data = q.poll();
			System.out.print(data + " ");
			
			for(int i=1; i<nodes.length; i++) {
				if(nodes[data][i] && !isVisited[i]) {
					q.offer(i);
					isVisited[i] = true;
				}
			}
		}
	}

}

/*
https://www.acmicpc.net/problem/1260

DFS와 BFS
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	150745	52423	30753	34.242%
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1 
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1 
1 2 4 3
1 2 3 4
예제 입력 2 
5 5 3
5 4
5 2
1 2
3 4
3 1
예제 출력 2 
3 1 2 5 4
3 1 4 2 5
예제 입력 3 
1000 1 1000
999 1000
예제 출력 3 
1000 999
1000 999
*/