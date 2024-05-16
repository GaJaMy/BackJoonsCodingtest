import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		long min = 0;
		long max = Long.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		long total = Long.parseLong(br.readLine());

		while (min <= max) {
			long sum = 0;
			long mid = (max + min) / 2;
			for (int i = 0; i < N; i++) {
				if (arr[i] <= mid) {
					sum += arr[i];
				} else {
					sum += mid;
				}
			}

			if (sum <= total) {
				min = mid + 1L;
			} else {
				max = mid - 1L;
			} 
		}

		System.out.println(max);

		br.close();
	}

}