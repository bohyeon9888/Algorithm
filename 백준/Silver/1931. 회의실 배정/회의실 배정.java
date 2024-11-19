import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int time[][] = new int[T][2];
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			time[t][0] = Integer.parseInt(st.nextToken());
			time[t][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});

		int count = 0;
		int end = 0;
		
		for (int i = 0; i < T; i++) {
			if (end <= time[i][0]) {
				end = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}

}