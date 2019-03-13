/*
 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 Array has distinct Element
 the trick here is ... find the one which is not sorted half 
 so you compaire if x at  mid > right then weh go that half and we do left = mid + 1 as we know mid is already greater than right  
 and elest right = mid 
 where do you return ?
 
 I made a mistake to try to find the element at mid which makes it very complicated to have all sort of conditions.
 cosider smaller inputs 5 1 2 or 2 1 for dry runs 
*/
class Solution {
    public int findMin(int[] nums) {
        int left = 0,  right = nums.length - 1;
        while(left < right) {
            //Case 1. The leftmost value is less than the rightmost value in the list: This means that the list is not rotated.
            if(nums[left] < nums[right]) 
                return nums[left];
            
            int mid = (left + right)/2;
            
            if(nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left];  // for i/p [1] 
    } 
}
