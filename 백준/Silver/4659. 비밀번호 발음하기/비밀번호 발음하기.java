import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		StringBuilder sb = new StringBuilder();
		while (!input.equals("end")) {
			int count = 0;
			String temp = "";
			char[] duplicate = new char[2];
			boolean ch = true;
			for (int i = 0; i < input.length(); i++) {
				char target = input.charAt(i);

				if (target == 'a' || target == 'e' || target == 'i' || target == 'o' || target == 'u') {
					count++;
					temp += "a";
				} else {
					temp += "b";
				}

				if (i == 0) {
					duplicate[0] = target;
				} else if (i == 1){
					duplicate[1] = target;
				} else {
					duplicate[0] = duplicate[1];
					duplicate[1] = target;
				}


				if (duplicate[0] == duplicate[1]) {
					if (!(duplicate[0] == 'e' || duplicate[0] == 'o')) {
						ch = false;
						break;
					}
				}

				if (temp.contains("aaa") || temp.contains("bbb")) {
					ch = false;
					break;
				}
			}

			if (count == 0) {
				ch = false;
			}

			if (ch) {
				sb.append("<" + input + "> is acceptable.\n");
			} else {
				sb.append("<" + input + "> is not acceptable.\n");
			}

			input = br.readLine();
		}

		System.out.println(sb);
		br.close();
	}
}

