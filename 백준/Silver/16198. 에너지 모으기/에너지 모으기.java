import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        List<Integer> marbles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            marbles.add(in.nextInt());
        }

        dfs(N, marbles, 0);
        System.out.println(max);
    }

    static int max = Integer.MIN_VALUE;
    private static void dfs(int len, List<Integer> marbles, int sum) {
        if (len == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < len - 1; i++) {
            int w = marbles.get(i - 1) * marbles.get(i + 1);
            int tmp = marbles.get(i);
            marbles.remove(i);
            dfs(len - 1, marbles, sum + w);
            marbles.add(i, tmp);
        }
    }
}
