import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int l = triangle.length;
        
        int dp[] = new int[(l * (l + 1)) / 2 + 1];
        // System.out.println((l * (l + 1)) / 2 + 1);
        
        dp[1] = triangle[0][0];
        int idx = 1;
        
        for (int i = 1; i <= l; i++) {
            for (int j = 0; j < i; j++) {
                // if (idx < 15) System.out.println(idx + " : " + dp[idx]);
                if ( i == l) {
                    answer = Math.max(answer, dp[idx]);
                    idx++;
                } else {
                    dp[idx + i] = Math.max(dp[idx] + triangle[i][j], dp[idx + i]);
                    // System.out.println((idx+i) + " : " + dp[idx + i]);
                    dp[idx + i + 1] = Math.max(dp[idx] + triangle[i][j + 1], dp[idx + i + 1]);
                    // System.out.println((idx+i+1) + " : " + dp[idx + i + 1]);
                    idx++;
                }
                
            }
            // System.out.println("===================");
        }
        
        
        return answer;
    }
}