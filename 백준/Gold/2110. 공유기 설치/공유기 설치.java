import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            int idx = 0;
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                if (houses[i] - houses[idx] >= mid) {
                    idx = i;
                    cnt++;
                }
            }

            if (cnt < c) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        System.out.println(right);

    }
}
