import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long sum = 0;
        long[] arr = new long[N + 1];
        long[] count = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken()) + arr[i - 1];
            int num = (int) (arr[i] % M);
            if (num == 0) sum ++;
            count[num]++;
        }

        for (int i = 0; i < M; i++) {
            if (count[i] > 1) {
                sum += (count[i] * (count[i] - 1)) / 2;
            }
        }

        System.out.println(sum);

    }
}
