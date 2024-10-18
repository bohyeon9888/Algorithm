import java.util.*;

class Solution {
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < costs.length; i++) {
            if (find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    public int find(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }
    
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) {
            parents[y] = x;
        }
    }
}