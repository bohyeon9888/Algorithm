import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    static int[] cal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        cal = new int[4];
        for (int i = 0; i < 4; i++) {cal[i] = Integer.parseInt(st.nextToken());}

        dfs(1, cal, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    private static void dfs(int depth, int[] cal, int ans) {
        if (depth == N) {
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] == 0) continue;

            cal[i]--;

            if (i == 0) dfs(depth + 1, cal, ans + nums[depth]);
            else if (i == 1) dfs(depth + 1, cal, ans - nums[depth]);
            else if (i == 2) dfs(depth + 1, cal, ans * nums[depth]);
            else dfs(depth + 1, cal, ans / nums[depth]);

            cal[i]++;
        }
    }
}
