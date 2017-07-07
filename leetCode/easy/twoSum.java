// Given an array of integers, return indices of the two numbers such that they
// add up to a specific target.
//
// You may assume that each input would have exactly one solution.
//
// Example:
// Given nums = [2, 7, 11, 15], target = 9,
//
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].
//WORKS
//speedup idea:
//sort and have i start at largest and j start at shortest ...
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int left = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }   
            }
        }
        
        return null;
    }
}
