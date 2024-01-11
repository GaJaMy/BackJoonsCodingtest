
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[] arr = new long[T];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);

        int p1 = 0;
        int p2 = arr.length - 1;
        int rp1 = 0;
        int rp2 = arr.length - 1;
        long min = Math.abs(arr[p1] + arr[p2]);
        while (p1 < p2) {
            if(Math.abs(arr[p1] + arr[p2]) < min) {
                min = Math.abs(arr[p1] + arr[p2]);
                rp1 = p1;
                rp2 = p2;
            }
            if(arr[p1]+arr[p2] < 0) {
                p1++;
            } else {
                p2--;
            }
        }

        System.out.println(arr[rp1] + " " + arr[rp2]);
    }
}
