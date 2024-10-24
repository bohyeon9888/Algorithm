import java.util.*;

class Solution {
    // union-find
    int n;
    int[] graph;
    String[] val;
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        n = 2500;
        graph = new int[n];
        val = new String[n];
        
        // 초기 부모 설정
        for (int i = 0; i < n; i++) {
            graph[i] = i;
        }
        
        for (int i = 0; i < commands.length; i++) {
            String[] comm = commands[i].split(" ");
            
            switch(comm[0]) {
                case "UPDATE":
                    update(comm);
                    break;
                    
                case "MERGE": 
                    merge(comm);
                    break;
                    
                case "UNMERGE":
                    unmerge(comm);
                    break;
                    
                case "PRINT":
                    int r = Integer.parseInt(comm[1]);
                    int c = Integer.parseInt(comm[2]);

                    int idx = find((r - 1) * 50 + (c - 1));

                    if (val[idx] == null) answer.add("EMPTY"); 
                    else answer.add(val[idx]);
                    
                    break;
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
    
    public void update(String[] comm) {
        if (comm.length == 4) {
            // "UPDATE r c value"
            int r = Integer.parseInt(comm[1]);
            int c = Integer.parseInt(comm[2]);
            int idx = find((r - 1) * 50 + (c - 1));
            
            val[idx] = comm[3];
            System.out.println("update " + comm[1] + " " + comm[2] + ": " + val[idx]);
            
        } else {
            // "UPDATE value1 value2"
            for (int i = 0; i < n; i++) {
                int parent = find(i);
                if (val[parent] != null && val[parent].equals(comm[1])) {
                    val[parent] = comm[2];
                    // System.out.println("update " + comm[1] + " " + comm[2] + ": " + val[parent]);
                }
            }
        }
    }
    
    public void merge(String[] comm) {
        int r1 = Integer.parseInt(comm[1]);
        int c1 = Integer.parseInt(comm[2]);
        int r2 = Integer.parseInt(comm[3]);
        int c2 = Integer.parseInt(comm[4]);
        
        int idx1 = (r1 - 1) * 50 + (c1 - 1);
        int idx2 = (r2 - 1) * 50 + (c2 - 1);
        if (idx1 == idx2) return;
        
        if (val[find(idx1)] == null && val[find(idx2)] != null) {
            union(idx2, idx1);
        } else {
            union(idx1, idx2);
        }
    }
    
    public void unmerge(String[] comm) {
        int r = Integer.parseInt(comm[1]);
        int c = Integer.parseInt(comm[2]);
        
        int idx = find((r - 1) * 50 + (c - 1));
        String v = val[idx];    // val[idx] 는 변할 수 있으므로 고정값으로 만들어줘야 함
        
        for (int i = 0; i < n; i++) {
            find(i);
        }
        
        for (int i = 0; i < n; i++) {
            int parent = find(i);
            if (parent == idx) {
                graph[i] = i;
                
                if (i == (r - 1) * 50 + (c - 1)) val[i] = v;
                else val[i] = null;
            }
        }
    }
    
    public int find(int x) {
        if (graph[x] == x) return x;
        
        return graph[x] = find(graph[x]);
    }
    
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) {
            val[y] = null;
            graph[y] = x;
        }
    }
}