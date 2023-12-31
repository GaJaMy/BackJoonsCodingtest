import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    public static boolean isPossible(int col,int[] queens,int depth) {
        for (int i = 0; i < depth; i++) {
            if (Math.abs(queens[i] - col) == Math.abs(depth - i) || queens[i] == col) {
                return false;
            }
        }
        return true;
    }

    public static void recursive(int[] queens,int depth,int N) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isPossible(i,queens,depth)) {
                queens[depth] = i;
                recursive(queens,depth+1,N);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] queens = new int[N];

        recursive(queens,0,N);

        System.out.println(count);
    }
}
