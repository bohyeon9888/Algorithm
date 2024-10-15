import java.util.*;

class Solution {
    
    static List<String> list = new ArrayList<>();
    static boolean[] isVisit;
    
    public String[] solution(String[][] tickets) {
        isVisit = new boolean[tickets.length];
        
        flight(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        
        return answer;
    }
    
    private void flight(int depth, String from, String path, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!isVisit[i] && tickets[i][0].equals(from)) {
                isVisit[i] = true;
                flight(depth+1, tickets[i][1], path + " " + tickets[i][1], tickets);
                isVisit[i] = false;
            }
        }
    }
}