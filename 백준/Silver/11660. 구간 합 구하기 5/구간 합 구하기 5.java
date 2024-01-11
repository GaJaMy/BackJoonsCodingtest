import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] mat = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int j = 1; j < N + 1; j++) {
				int val = Integer.parseInt(st.nextToken());
				sum += val;
				mat[i][j] = sum;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int result = 0;
			for (int j = x1; j <= x2; j++) {
				result += mat[j][y2] - mat[j][y1 - 1];
			}

			sb.append(result + "\n");
		}

		System.out.println(sb);

		br.close();
	}
}
