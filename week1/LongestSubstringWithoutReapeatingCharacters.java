public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int start = 0;
        int result = 1;
        boolean[] exist = new boolean[256];

        for (int end = 0; end < s.length(); ++end) {
        	char cur = s.charAt(end);
        	if (!exist[cur]) {
        		exist[cur] = true;
        	} else {
        		result = Math.max(result, end - start);
                start = findNextStartPos(start, end, s, cur, exist);
        	}
        }
        result = Math.max(result, s.length() - start);
        return result;        
    }
    private int findNextStartPos(int start, int end, String s, char repeatedChar, boolean[] exist) {
        int res = start;
        for (int i = start; i < end; ++i) {
            if (s.charAt(i) == repeatedChar) {
                res = i + 1;
                break;
            }
            exist[s.charAt(i)] = false;
        }
        return res;
    }
}