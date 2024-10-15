import java.util.*;
import java.io.*;

public class Main {
	static int N, M, H;
	static int[][][] box;
	static int[][][] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		dist = new int[H][N][M];
		
		Queue<int[]> tomato = new ArrayDeque<int[]>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[h][i][j] = Integer.parseInt(st.nextToken());
					dist[h][i][j] = -1;
					if (box[h][i][j] == 1) {
						tomato.offer(new int[] {h, i, j});
						dist[h][i][j] = 0;
					}
				}
			}
		}
		
		bfs(tomato);
		
		int result = 0;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					result = Math.max(result, dist[h][i][j]);
					if (dist[h][i][j] == -1 && box[h][i][j] == 0) {
						result = -1;
						System.out.println(result);
						return;
					}
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}
	
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	
	private static void bfs(Queue<int[]> tomato) {
		while(!tomato.isEmpty()) {
			int[] tmp = tomato.poll();
			int h = tmp[0];
			int r = tmp[1];
			int c = tmp[2];
			
			for (int d = 0; d < 6; d++) {
				int nr = r + dx[d];
				int nc = c + dy[d];
				int nh = h + dz[d];
				
				if (nr >= N || nr < 0 || nc >= M || nc < 0 || nh >= H || nh < 0 || box[nh][nr][nc] != 0 || dist[nh][nr][nc] > -1) continue;
				
				dist[nh][nr][nc] = dist[h][r][c] + 1;
				tomato.offer(new int[] {nh, nr, nc});
			}
		}
	}
}
