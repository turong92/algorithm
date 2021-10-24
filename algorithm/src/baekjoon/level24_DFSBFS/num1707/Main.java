package baekjoon.level24_DFSBFS.num1707;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			
			for(int i=0; i<V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			int[] color = new int[V];
			String result = "YES";
			for(int i=0; i<V; i++) {
				if(color[i] == 0) {
					if(!bfs(i, color, graph)) {
						result = "NO";
						break;
					}
				}
			}
			
			System.out.println(result);
		}
	}
	
	public static boolean bfs(int n, int[] color, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		color[n] = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(Integer i : graph.get(cur)) {
				if(color[cur] == color[i]) {
					return false;
				}else if(color[i] == 0) {
					color[i] = color[cur] * -1;
					q.offer(i);
				}
			}
		}
		
		return true;
	}

}

/*
https://www.acmicpc.net/problem/1707

이분 그래프
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	52985	13650	8024	23.226%
문제
그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.

그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K가 주어진다. 각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다. 각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 각 줄에 인접한 두 정점의 번호 u, v (u ≠ v)가 빈 칸을 사이에 두고 주어진다. 

출력
K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.

제한
2 ≤ K ≤ 5
1 ≤ V ≤ 20,000
1 ≤ E ≤ 200,000
예제 입력 1 
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
예제 출력 1 
YES
NO
*/