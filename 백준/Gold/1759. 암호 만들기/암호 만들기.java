import java.io.*;
import java.util.*;

public class Main {
	static int R, N;
	static String inputs[], password[];
	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		inputs = new String[N];
		isSelected = new boolean[N];
		password = new String[R];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) inputs[i] = st.nextToken();
		
		Arrays.sort(inputs);
		
		permutation(0, 0);

		System.out.println(sb.toString());
	}

	private static void permutation(int idx, int start) {
		if (idx == R) {
			int mCnt = 0, jCnt = 0;
			for (int i = 0; i < R; i++) {
				if ("aeiou".contains(password[i])) mCnt++;
				else jCnt++;
			}
			
			if (mCnt >= 1 && jCnt >= 2) {
				for (int i = 0; i < R; i++) {
					sb.append(password[i]);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (isSelected[i]) continue;
			
			password[idx] = inputs[i];
			isSelected[i] = true;
			permutation(idx+1, i+1);
			isSelected[i] = false;
		}
	}

}
