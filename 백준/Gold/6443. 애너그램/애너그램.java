import java.io.*;

public class Main {
    static int[] check;
    static char[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char[] chars = str.toCharArray();

            check = new int[26];
            for (char c : chars) {
                check[c - 'a']++;
            }

            result = new char[str.length()];
            tracking(0);
        }

        System.out.println(sb);
    }

    private static void tracking(int depth) {
        if (depth == result.length) {
            sb.append(result).append('\n');
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (check[i] > 0) {
                result[depth] = (char) ('a' + i);
                check[i]--;
                tracking(depth + 1);
                check[i]++;
            }
        }
    }
}
