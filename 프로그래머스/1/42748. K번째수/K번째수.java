import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int tc = commands.length;
        int[] answer = new int[tc];
        
        for (int t = 0; t < tc; t++) {
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            
            int[] arr = new int[j - i + 1];
            for (int h = i; h <= j; h++) {
                arr[h - i] = array[h - 1];
            }
            
            Arrays.sort(arr);
            answer[t] = arr[k - 1];
        }
        return answer;
    }
}