package com.ccl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther ccl
 * @create 2020/7/25 18:06
 */
public class Solution01 {
    public static void main(String[] args) {
        int []nums = {3,2,4};
        int target = 6;
        int[] ints = twoSum1(nums, target);
        System.out.print("[");
        for (int a = 0;a<ints.length-1;a++){
            System.out.print(ints[a]+",");
        }
        System.out.println(ints[ints.length-1] + "]");
    }
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int complete = target - nums[i];
            if(map.containsKey(complete) && map.get(complete) != i){
                return new int[]{i, map.get(complete)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
    public static int[] twoSum1(int[] nums, int target){
       for(int i=0;i<nums.length;i++){
           for (int j = i+1; j< nums.length;j++){
               if(target - nums[i] == nums[j]){
                   return new int[] {i,j};
               }
           }
       }
        throw new IllegalArgumentException("No two sum solution");
    }

}
