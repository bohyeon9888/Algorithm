import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 0;
        while ( tc++ < 10) {
            int n = Integer.parseInt(br.readLine());
            if ( n > 1000) return;

            int[] buildings = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                if (st.hasMoreTokens()) {
                    buildings[i] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            for (int i = 2; i < n - 2; i++) {
                // 좌우 최대 높이 구하기
                int max = Math.max(buildings[i - 1], Math.max(buildings[i - 2], Math.max(buildings[i + 1], buildings[i + 2])));

                if (buildings[i] > max) {
                    cnt += (buildings[i] - max);
                }
            }

            sb.append("#" + tc + " " + cnt + "\n");
        }

        System.out.print(sb);
	}
}