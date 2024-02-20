import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if (A == 0 && B == 0 && C == 0) {
				break;
			}

			list.add(A);
			list.add(B);
			list.add(C);

			Collections.sort(list);
			if (list.get(2).intValue() >= list.get(0).intValue() + list.get(1).intValue()) {
				System.out.println("Invalid");
			} else if (list.get(0).intValue() == list.get(1).intValue() && list.get(1).intValue() == list.get(2).intValue()) {
				System.out.println("Equilateral");
			} else if (list.get(0).intValue() == list.get(1).intValue() || list.get(1).intValue() == list.get(2).intValue() || list.get(2).intValue() == list.get(0).intValue()){
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
		}

		br.close();
	}
}
