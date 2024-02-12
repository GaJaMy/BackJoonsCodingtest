import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[][] dp = new long[30][30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp[0][0] = 1;

		combi(29,29);
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			System.out.println(dp[N][R]);
		}
		br.close();
	}

	public static void combi(int n, int r){
		for (int i = 0; i <= n; i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}

		for (int i = 2; i <=29; i++) {
			for (int j = 1; j <= i ; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
	}
}
