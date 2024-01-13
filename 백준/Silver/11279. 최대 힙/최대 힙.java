import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue pq = new PriorityQueue(Comparator.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());

			if (val == 0) {
				if (pq.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			} else {
				pq.add(val);
			}
		}

		System.out.println(sb);
		br.close();
	}
}
