import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int xx = Math.abs(x1-x2);
			int yy = Math.abs(y1-y2);
			
			if (xx < yy) {
				int tmp = xx;
				xx = yy;
				yy = tmp;
			}
			
			int ans = xx / 2 * 4 + xx % 2;
			if (yy % 2 == 1) {
				if (xx % 2 == 1) ans ++;
				else ans--;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}

}