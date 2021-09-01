package com.atguigu.algorithm.arrays;

import java.util.HashMap;

public class TwoSum {
    //测试
    public static void main(String[] args) {
        int[] nums = {2,7,9,11};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum3(nums, target);
        for (int i = 0; i <ints.length ; i++) {
            System.out.println(ints[i]);
        }
    }
    /**
     * 方法一：暴力破解 时间复杂度O(n^2) 空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        //如果找不到 抛出异常
        throw new IllegalArgumentException("no solution");
    }

    /**
     * 方法二：哈希表保存所有数的信息 时间复杂度O(n) 空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        //定义一个哈希表
        HashMap<Integer,Integer> map = new HashMap<>();
        //1.遍历数组，把所有数据保存到hash表
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }
        //2.再次遍历数组，寻找每个数对应的哪个数是否存在
        for (int i = 0; i < n; i++) {
            int thatNum = target-nums[i];
            //如果哪个数存在，并且不是当前数自身，就直接返回结果
            if(map.containsKey(thatNum)&&map.get(thatNum)!=i){
                return new int[]{i,map.get(thatNum)};
            }
        }
        //如果找不到 抛出异常
        throw new IllegalArgumentException("no solution");
    }
    /**
     * 方法三：遍历一次哈希表 时间复杂度O(n) 空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        int n = nums.length;
        //定义一个哈希表
        HashMap<Integer,Integer> map = new HashMap<>();
        //遍历数组，寻找每个数对应的哪个数是否存在
        for (int i = 0; i < n; i++) {
            int thatNum = target-nums[i];
            //如果哪个数存在，并且不是当前数自身，就直接返回结果
            if(map.containsKey(thatNum)&&map.get(thatNum)!=i){
                return new int[]{map.get(thatNum),i};
            }
            map.put(nums[i],i);
        }
        //如果找不到 抛出异常
        throw new IllegalArgumentException("no solution");
    }
}