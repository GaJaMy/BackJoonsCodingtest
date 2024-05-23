import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int idx = 0;

		int num = 1;
		while (true) {

			String strNum = Integer.toString(num);

			for (int i = 0; i < strNum.length(); i++) {
				if (idx < str.length() && strNum.charAt(i) == str.charAt(idx) ) {
					idx++;
				}
			}

			if (idx == str.length()) {
				break;
			}

			num++;
		}
		System.out.println(num);

		br.close();
	}

}