import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();

            dfs(1, 1, 1, 0, "1");
            sb.append("\n");
        }

        sc.close();
        System.out.println(sb);
    }

    public static void dfs(int nowNum, int sign, int depth, int sum, String result) {
        if (depth == n) {
            sum += (nowNum * sign);
            if (sum == 0) sb.append(result).append("\n");
            return;
        }

        dfs(nowNum * 10 + (depth + 1), sign,depth + 1, sum, result + " " + (depth + 1));
        dfs(depth + 1, 1, depth + 1, sum + (sign * nowNum), result + "+" + (depth + 1));
        dfs(depth + 1, -1, depth + 1, sum + (sign * nowNum), result + "-" + (depth + 1));
    }
}