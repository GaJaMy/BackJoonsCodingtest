import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int answer = 0;
        int maxVal = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            arr[idx] = val;
            if (maxVal <= arr[idx]) {
                maxVal = arr[idx];
            }
        }

        int start = 1;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == maxVal) {
                answer += (i - start) * max;
                start = i;
                break;
            } else {
                if (max < arr[i]) {
                    answer += (i - start) * max;
                    start = i;
                    max = arr[i];
                }
            }
        }

        max = 0;
        int end = arr.length - 1;
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] == maxVal) {
                answer += (end - i) * max;
                end = i;
                break;
            } else {
                if (max < arr[i]) {
                    answer += (end - i) * max;
                    end = i;
                    max = arr[i];
                }
            }
        }

        answer += (end - start + 1) * maxVal;

        System.out.println(answer);

        br.close();
    }
}