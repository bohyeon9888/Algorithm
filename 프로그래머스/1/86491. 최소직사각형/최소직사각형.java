import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int[] minArr = new int[sizes.length];
        int[] maxArr = new int[sizes.length];
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] >= sizes[i][1]) {
                minArr[i] = sizes[i][1];
                maxArr[i] = sizes[i][0];
            } else {
                minArr[i] = sizes[i][0];
                maxArr[i] = sizes[i][1];
            }
        }
        
        Arrays.sort(minArr);
        Arrays.sort(maxArr);
        
        int answer = minArr[sizes.length - 1] * maxArr[sizes.length - 1];
        
        return answer;
    }
}