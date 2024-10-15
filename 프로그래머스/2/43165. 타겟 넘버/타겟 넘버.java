class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    public void dfs(int[] arr, int depth, int target, int sum) {
        if (depth == arr.length) {
            if (sum == target) answer++;
            return;
        }
        
        dfs(arr, depth + 1, target, sum + arr[depth]);
        dfs(arr, depth + 1, target, sum - arr[depth]);
    }
}