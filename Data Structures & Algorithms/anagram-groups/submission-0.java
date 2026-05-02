
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listOfList = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue; 
            
            ArrayList<String> list = new ArrayList<>();
            String word = strs[i];
            list.add(word);
            visited[i] = true;
            
            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(word, strs[j])) {
                    list.add(strs[j]);
                    visited[j] = true; 
                }
            }
            listOfList.add(list);
        }
        return listOfList;
    }

    public static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) return false; // Quick check for length
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        
        return map1.equals(map2); // Compare the maps
    }
}
