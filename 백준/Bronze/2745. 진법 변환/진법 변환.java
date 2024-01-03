import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		HashMap<Character,Integer> m = new HashMap<>();


		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());

		for (int i = 10; i < B; i++) {
			m.put((char)('A' + i-10),i);
		}


		int result = 0;
		for (int i = 0; i < N.length(); i++) {
			int val = 0;
			if (N.charAt(i) >= 'A' && N.charAt(i) <= 'Z') {
				val = m.get(N.charAt(i));
			} else {
				val = N.charAt(i) - '0';
			}
			result += Math.pow(B,N.length()-1-i) * val;
		}

		System.out.println(result);
		br.close();
	}
}
