import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static class country {
		int number;
		int gold;
		int silver;
		int bronze;

		public country(int number, int gold, int silver,int bronze) {
			this.number = number;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		country[] arr = new country[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			arr[i] = new country(number , gold, silver, bronze);
		}

		Arrays.sort(arr, new Comparator<country>() {
			@Override
			public int compare(country o1, country o2) {
				if (o1.gold < o2.gold) {
					return 1;
				} else if (o1.gold > o2.gold) {
					return -1;
				} else {
					if (o1.silver < o2.silver) {
						return 1;
					} else if (o1.silver > o2.silver) {
						return -1;
					} else {
						if (o1.bronze < o2.bronze) {
							return 1;
						} else if (o1.bronze > o2.bronze) {
							return -1;
						} else {
							return 0;
						}
					}
				}
			}
		});

		for (int i = 0; i < N; i++) {
			if (arr[i].number == K) {
				System.out.println(i);
				break;
			}
		}

		br.close();
	}
}

