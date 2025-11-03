package Leetcode;
import java.lang.reflect.Array;
import java.util.*;   

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<List<String>>();
        Map<String,List<String>> mp = new HashMap<String, List<String>>();
        for(String word : strs){
            char[] charWord = word.toCharArray();
            Arrays.sort(charWord);
            String orderedWord = new String(charWord);
            if(!mp.containsKey(orderedWord)){
                mp.put(orderedWord, new ArrayList<>());  
            }
            mp.get(orderedWord).add(word);
        }
        answer.addAll(mp.values());
        return answer;

         
    }
}
