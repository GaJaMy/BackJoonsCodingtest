import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] title = new String[N];
		int[] power = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			title[i] = st.nextToken();
			power[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(br.readLine());

			int start = 0;
			int end = N - 1;

			while (start <= end) {
				int mid = (start + end) / 2;

				if (power[mid] < input) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			sb.append(title[start]).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}