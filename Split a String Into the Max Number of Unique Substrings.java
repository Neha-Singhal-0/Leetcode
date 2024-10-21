//Solution link :https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/solutions/5946496/simple-to-understand/
//Problem Link : https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/submissions/1429162036/?envType=daily-question&envId=2024-10-21



class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<>());
    }
    private int backtrack(int start, String s, HashSet<String> seen) {
        if (start == s.length()) {
            return 0; 
        }
        int maxSplits = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!seen.contains(substring)) {
                seen.add(substring); 
                maxSplits = Math.max(maxSplits, 1 + backtrack(end, s, seen));
                seen.remove(substring);
            }
        }
        return maxSplits;
    }
}
