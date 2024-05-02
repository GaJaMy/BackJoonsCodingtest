import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] X = new int[M];

		for (int i = 0; i < M; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}

		int h = 1;
		while (true) {

			int start = X[0] - h;
			int end = X[M-1] + h;
			if (start > 0 || end < N) {
				h++;
				continue;
			}

			boolean ch = true;
			for (int i = 1; i < M; i++) {
				if (X[i] - h > end) {
					ch = false;
					break;
				}
				end = X[i] + h;
			}

			if (ch) {
				System.out.println(h);
				break;
			}
			h++;
		}

		br.close();
	}

}