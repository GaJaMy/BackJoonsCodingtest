import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int p = 0;
		int q = X - 1;
		int sum = 0;
		for (int i = p; i <= q; i++) {
			sum += arr[i];
		}

		int max = sum;
		int count = 1;
		while (q < N-1) {
			sum += arr[q+1];
			sum -= arr[p];

			if (max < sum) {
				max = sum;
				count = 1;
			} else if (max == sum) {
				count++;
			}

			q++;
			p++;
		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(count);
		}

		br.close();
    }
}