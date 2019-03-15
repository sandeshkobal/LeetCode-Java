https://leetcode.com/problems/largest-number/

For example:
[9,32]				[32,3,31]		[0,0,0]
return "931"			return "33231"		return "0"

The idea here is basically implement a String comparator to decide
which String should come first during concatenation.

class Solution {
    class SortByDigits implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            String str1 = a.toString() + b.toString();
            String str2 = b.toString() + a.toString();
            
            // Like we do, a-b for ascending and b-a for descending 
            // similarly we gonna compare str2 with str1 bcz we want descending 
            return str2.compareTo(str1);
        }
    }
    
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0) return "";
        
        Integer []numsInt = new Integer[nums.length];
        for(int i=0;i<nums.length;i++)
            numsInt[i] = new Integer(nums[i]);
                
        Arrays.sort(numsInt,new SortByDigits());
	// if numInt was List<Integer> you can use Collections.sort(numsInt,new SortByDigits());
	
        StringBuffer str = new StringBuffer();
        for(int i=0;i<nums.length;i++)
            str.append(numsInt[i]);
        
        // for ip = [0,0,0]
        if(str.charAt(0)=='0')
            return "0";
        
        return str.toString();
    }
}

In terms of Time and Space Complexity:
Let's assume:
the length of input array is n,
average length of Strings in s_num is k,
Then, compare 2 strings will take O(k).
Sorting will take O(n*logn)
Appending to StringBuilder takes O(n).
So total will be O(k*nlog(nk)) + O(n) = O(k*nlog(nk)).

Space is pretty straight forward: O(n).