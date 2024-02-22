import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Integer.parseInt(br.readLine());

		long answer = 1;
		if (N==1) {
			System.out.println(answer);
            return;
		}

		long start = 2;
		long end = 7;

		while (!(start <= N && end >= N)) {
			start += answer * 6;
			end += (answer + 1) * 6;
			answer++;
		}

		System.out.println(answer + 1);

		br.close();
	}
}
