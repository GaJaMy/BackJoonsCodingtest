import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		String val;
		int count;

		public Node() {
			this.val = "";
			this.count = 0;
		}

		public Node(String val, int count) {
			this.val = val;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Node> words = new ArrayList<>();

		HashMap<String,Integer> m = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();

			if (word.length() >= M) {
				m.put(word,m.getOrDefault(word,0) + 1);
			}
		}

		for(String key : m.keySet()) {
			words.add(new Node(key,m.get(key)));
		}

		Collections.sort(words, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.count > o2.count) {
					return -1;
				} else if(o1.count < o2.count) {
					return 1;
				} else {
					if (o1.val.length() > o2.val.length()) {
						return -1;
					} else if (o1.val.length() < o2.val.length()) {
						return 1;
					} else {
						return o1.val.compareTo(o2.val);
					}
				}
			}
		});

		StringBuilder sb = new StringBuilder();

		for (Node str : words) {
			sb.append(str.val + "\n");
		}

		System.out.println(sb);
		br.close();
	}
}
