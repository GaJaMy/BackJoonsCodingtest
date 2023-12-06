import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static StringBuilder sb = new StringBuilder();
	public static int count = 0;

	public static void hanoi(int n,int start, int mid, int to) {
		if (n == 1) {
			count++;
			sb.append(start + " " + to+"\n");
			return;
		}
		hanoi(n-1,start,to,mid);
		count++;
		sb.append(start + " " + to + "\n");
		hanoi(n-1,mid,start,to);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		hanoi(N,1,2,3);
		System.out.println(count);
		System.out.println(sb.toString());
	}
}
