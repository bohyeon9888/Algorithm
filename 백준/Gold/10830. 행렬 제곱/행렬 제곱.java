import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = pow(matrix, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) sb.append(result[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static public int[][] pow(int[][] a, long b) {
        if (b == 1L) return a;

        int[][] result = pow(a, b/2);
        result = multiply(result, result);

        if (b % 2 == 1L) result = multiply(result, matrix);

        return result;
    }

    static public int[][] multiply(int[][] m1, int[][] m2) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }
}
