import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int answer = 0;

        for (int i = 0; i < N - 1; i++) {
            String T = br.readLine();
            int[] alpha = new int[26];

            for (int j = 0; j < S.length(); j++) {
                alpha[S.charAt(j) - 'A']++;
            }

            int sum = 0;
            for (int j = 0; j < T.length(); j++) {
                if (alpha[T.charAt(j) - 'A'] > 0) {
                    sum++;
                    alpha[T.charAt(j) - 'A']--;
                }
            }

            if (T.length() == S.length() && (sum == S.length() || sum == S.length() - 1)) {
                answer++;
            } else if (S.length() == T.length() - 1 && sum == T.length() - 1) {
                answer++;
            } else if (S.length() == T.length() + 1 && sum == T.length()) {
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}