import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void dfs(int[][] arr,boolean[] visited,int startIdx,int count,int N) {
		if (count == N) {
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && arr[startIdx][i] == 1) {
				System.out.print(i + " ");
				visited[i] = true;
				dfs(arr,visited,i,count+1,N);
			}
		}
	}

	public static void bfs(int[][] arr, int startIdx, int N) {
		Queue<Integer> queue = new LinkedList<>();

		boolean[] visited = new boolean[N+1];

		visited[startIdx] = true;
		queue.add(startIdx);
		System.out.print(startIdx + " ");

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && arr[cur][i] == 1) {
					queue.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			arr[first][second] = 1;
			arr[second][first] = 1;
		}

		boolean[] visited = new boolean[N+1];

		visited[V] = true;
		System.out.print(V + " ");
		dfs(arr,visited,V,0,N);
		System.out.println();

		bfs(arr,V,N);
		System.out.println();

		br.close();
	}

}
