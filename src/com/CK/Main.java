package com.CK;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b , b , b , c, c";
        String[] banned = new String[]{"a"};
        Solution solution = new Solution();
        System.out.println(solution.mostCommonWord(paragraph, banned));
    }
}

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.asList(banned);
        Map<String, Integer> wordFrequency = new HashMap<>();
        String returnString;
        String[] wordList = paragraph.trim().split("\\W+");
        for (String rawWord : wordList) {
            String realWord = rawWord.replaceAll("\\W", "").toLowerCase();
            Integer freq = wordFrequency.get(realWord);
            if (!realWord.equals("") && !bannedList.contains(realWord)) {
                if (freq != null) {
                    wordFrequency.put(realWord, freq + 1);
                } else {
                    wordFrequency.put(realWord, 1);
                }
            }
        }
        Integer maxVal = Collections.max(wordFrequency.values());
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue().equals(maxVal)) {
                return entry.getKey();
            }
        }
        return null;
    }
}

class Solution2 {

    public String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}