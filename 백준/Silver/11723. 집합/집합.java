import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		String input = "";
		HashSet<Integer> s = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		while (M != 0) {
			input = br.readLine();

			if (input.equals("all")) {
				s = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
			} else if (input.equals("empty")) {
				s.clear();
			} else {
				StringTokenizer st = new StringTokenizer(input);
				String command = st.nextToken();
				int val = Integer.parseInt(st.nextToken());

				switch (command) {
					case "add" : {
						s.add(val);
						break;
					}
					case "remove" : {
						s.remove(val);
						break;
					}
					case "check" : {
						if (s.contains(val)) {
							sb.append("1\n");
						} else {
							sb.append("0\n");
						}
						break;
					}
					case "toggle" : {
						if (s.contains(val)) {
							s.remove(val);
						} else {
							s.add(val);
						}
						break;
					}
				}
			}
			M--;
		}

		System.out.println(sb);
		br.close();
	}
}
