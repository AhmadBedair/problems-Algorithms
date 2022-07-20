// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
// Example 2:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 3:

// Input: nums = [1,2,3]
// Output: 3
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000




class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        if(nums.length==3)
            return Math.max(nums[0],Math.max(nums[1],nums[2]));
        int nums1[] = Arrays.copyOfRange(nums,0,nums.length-1);
        int nums2[] = Arrays.copyOfRange(nums,1,nums.length);
        int []table = new int[nums.length];
        int out1 = helper(table,nums1);
        int out2 = helper(table,nums2);
        return Math.max(out1,out2);
        
        
    }
   public static int helper(int[]table,int[]nums){
        table[0] = 0;
        table[1] = nums[0];
        table[2] = Math.max(nums[0],nums[1]);
        for(int i=3;i<table.length;i++){
            table[i] = Math.max(table[i-1],table[i-2]+nums[i-1]);
        }
        return table[table.length-1];
    }
}