// https://leetcode.com/problems/remove-invalid-parentheses/ 
Input: "()())()"
Output: ["()()()", "(())()"]
// Sol - https://leetcode.com/problems/remove-invalid-parentheses/discuss/75034/Easiest-9ms-Java-Solution

// for First pass count which ones ( , ) to remove and how many 
// then we do dfs with use it or dont use it. In the end we add result to set to avoid duplicate.  
class Solution { 
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        //First pass count which ones ( , ) to remove and how many 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            } else if (s.charAt(i) == ')') {
                if (rmL != 0) 
                    rmL--;
                else 
                    rmR++;
            }
        }
        Set<String> res = new HashSet<>();                  // Set is very Important bcz we gonna get duplicates in the ans.
        dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);
        return new ArrayList<String>(res);   // set to arrayList 
    }

    public void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        if (i == s.length()) {
            // open is very important  for example for ip )() we dont want )( as the ans open=1 will avoid that.
            if (rmL == 0 && rmR == 0 && open == 0)  
                res.add(sb.toString());      
            return;
        }

        char c = s.charAt(i); 
        int len = sb.length();

        if (c == '(') {
            dfs(s, i + 1, res, sb, rmL - 1, rmR, open);		    // not use (
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open + 1);       // use (

        } else if (c == ')') {
            dfs(s, i + 1, res, sb, rmL, rmR - 1, open);	            // not use  )
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open - 1);  	    // use )

        } else {
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open);	
        }

        sb.setLength(len);        
    }
}
