import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int oneCount = 0;
		int zeroCount = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				oneCount++;
			} else {
				zeroCount++;
			}
		}

		oneCount /= 2;
		zeroCount /= 2;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1' && oneCount != 0) {
				oneCount--;
				continue;
			} else {
				sb.append(s.charAt(i));
			}
		}

		s = sb.toString();
		sb.setLength(0);

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '0' && zeroCount != 0) {
				zeroCount--;
				continue;
			} else {
				sb.append(s.charAt(i));
			}
		}

		s = sb.reverse().toString();

		System.out.println(s);
		br.close();
	}

}