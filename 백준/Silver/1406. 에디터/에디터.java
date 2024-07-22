import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        Stack<Character> LS = new Stack<>();
        Stack<Character> RS = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            LS.push(S.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        while(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("L")) {
                if (!LS.empty()) {
                    RS.push(LS.pop());
                }
            } else if (cmd.equals("D")) {
                if (!RS.empty()) {
                    LS.push(RS.pop());
                }
            } else if (cmd.equals("P")) {
                LS.push(st.nextToken().charAt(0));
            } else if (cmd.equals("B")) {
                if (!LS.empty()) {
                    LS.pop();
                }
            }
            M--;
        }

        StringBuilder sb = new StringBuilder();
        while (!RS.empty()) {
            LS.push(RS.pop());
        }

        while (!LS.empty()) {
            sb.append(LS.pop());
        }

        System.out.println(sb.reverse());

        br.close();
    }
}