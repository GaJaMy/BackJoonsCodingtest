import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());

		for (int i = 0; i < P; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int answer = 0;
			for (int j = 0; j < 20; j++) {
				arr.add(Integer.parseInt(st.nextToken()));
				for (int k = 0; k < j; k++) {
					if (arr.get(k) > arr.get(arr.size() - 1)) {
						arr.add(k,arr.get(arr.size()-1));
						arr.remove(arr.size() - 1);
						answer += (arr.size() - k - 1);
					}
				}
			}

			System.out.println(i + 1 + " " + answer);
		}
		br.close();
	}
}

