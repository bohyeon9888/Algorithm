class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for (int h = 3; h <= sum; h++) {
            int w = sum / h;
            if (w < 3) continue;
            
            if (w >= h) {
                if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}
