/*
278. First Bad Version
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls to the API.
Given n = 5, and version = 4 is the first bad version.
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=1, right=n;
        while(left<right){
            int mid = left+(right-left)/2;
            
            if(isBadVersion(mid))
                right = mid;
            else 
                left = mid+1;
        }
        return left;
    }
}
