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
//DOESNT WORK

import java.util.PriorityQueue;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        PriorityQueue<Integer> sorted = new PriorityQueue<Integer>();
        for(int i = 0; i<nums.length; i++){
//            if(nums[i] <= target){
                sorted.add(nums[i]);
//            }
        }
        if(sorted.size() == 2){
            int first = indexInNums(sorted.poll(), nums);
            nums[first] = Integer.MAX_VALUE;
            int second = indexInNums(sorted.poll(), nums);
            ans[0] = first;
            ans[1] = second;
            return ans;
        }
        else{
            Integer[] sortArr = sorted.toArray(new Integer[sorted.size()]);
            int len = sortArr.length;
            for(int i = 0; i<len; i++){
                Integer largest = sortArr[len-1];
                sorted.remove(largest);
                Integer looking = target-largest;
                if(sorted.contains(looking)){
                    ans[0] = indexInNums(looking, nums);
                    nums[indexInNums(looking, nums)] = Integer.MAX_VALUE;
                    ans[1] = indexInNums(largest, nums);
                    return ans;
                }
                else{

                    len--;
                }
            }
        }
        return ans;
    }
    public int indexInNums(int ans, int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(ans == nums[i]){
                return i;
            }
        }
        return -1;

    }


}
