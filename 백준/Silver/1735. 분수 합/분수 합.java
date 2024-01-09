import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

		int a1,a2,b1,b2;

		StringTokenizer st = new StringTokenizer(br.readLine());
		a1 = Integer.parseInt(st.nextToken());
		a2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		b1 = Integer.parseInt(st.nextToken());
		b2 = Integer.parseInt(st.nextToken());

		int r1,r2,max;

		r2 = a2 * b2;
		r1 = a1 * b2 + a2 * b1;

		max = Math.max(r1,r2);

		boolean c = true;
		while(c) {
			c = false;
			for (int i = 2; i <= max; i++) {
				if (r1 % i == 0 && r2 % i == 0) {
					r1 = r1 / i;
					r2 = r2 / i;
					c = true;
					break;
				}
			}
			max = Math.max(r1,r2);
		}

		System.out.println(r1 + " " + r2);

		br.close();
	}

}
