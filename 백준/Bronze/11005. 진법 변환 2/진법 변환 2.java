import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		Map<Integer, Character> m = new HashMap<>();

		for (int i = 10; i <= B; i++) {
			m.put(i,(char)('A' + i - 10));
		}

		StringBuilder sb = new StringBuilder();

		while(N != 0) {
			int val = N % B;

			if (B > 10 && m.containsKey(val)) {
				sb.append(m.get(val));
			} else {
				sb.append(val);
			}

			N = N / B;
		}

		sb.reverse();
		System.out.println(sb);

		br.close();
	}

}
