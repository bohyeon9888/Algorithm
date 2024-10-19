import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> playsNum = new HashMap<>();
        Map<String, Map<Integer, Integer>> songsNum = new HashMap<>(); 
        
        for (int i = 0; i < genres.length; i++) {
            playsNum.put(genres[i], playsNum.getOrDefault(genres[i], 0) + plays[i]);
        
            if (songsNum.containsKey(genres[i])) {
                songsNum.get(genres[i]).put(i, plays[i]);
            } else {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                songsNum.put(genres[i], map);
            }
            
        }
        
        List<String> keySet = new ArrayList<>(playsNum.keySet());
        keySet.sort((o1, o2) -> playsNum.get(o2).compareTo(playsNum.get(o1)));
        
        for (String key : keySet) {
            Map<Integer, Integer> map = songsNum.get(key);
            List<Integer> musicKey = new ArrayList<>(map.keySet());
            
            musicKey.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
            answer.add(musicKey.get(0));
            if (musicKey.size() > 1) {
                answer.add(musicKey.get(1));
            }
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}