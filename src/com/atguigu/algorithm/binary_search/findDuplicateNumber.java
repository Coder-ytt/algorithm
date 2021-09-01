package com.atguigu.algorithm.binary_search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class findDuplicateNumber {

    //方法一：双指针暴力组合  时间超限
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        //定义双指针
        int first = 0;
        int next = 0;
        for (int i = 0; i <n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
    //方法二：使用hashmap保存每个数组出现的次数
    public static int findDuplicate2(int[] nums) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        //遍历所有元素，统计count值
        for (Integer num:nums) {
            if(countMap.containsKey(num)){
                return num;//如果出现  那么就是重复数
            }else{
                countMap.put(num,1);
            }
        }
        return -1;
    }

    //方法三：使用hashset保存数据，判断是否出现过
    public static int findDuplicate3(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        //遍历所有元素，统计count值
        for (Integer num:nums) {
            if(hashSet.contains(num)){
                return num;//如果出现  那么就是重复数
            }else{
                hashSet.add(num);
            }
        }
        return -1;
    }

    //方法四：先排序 然后比较相邻元素
    public static int findDuplicate4(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-1; i++) {
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
    // 方法五：二分查找，查找1~N的自然数序列，寻找target
    public static int findDuplicate5(int[] nums) {
        int left= 1;
        int right = nums.length-1;
        while (left<=right){
            //计算中间值
            int mid =(left+right)/2;

            //对当前的mid计算count值
            int count = 0;
            for (int i = 0; i <nums.length ; i++) {
                if(nums[i]<=mid){
                    count++;
                }
            }
            //判断count和mid的大小关系
            if(count<=mid){
                left = mid+1;//count小于等于mid自身，说明mid比target小，左指针右移
            }else{
                right = mid;
            }
            //当左右指针重合时找到target
            if(left==right){
                return left;
            }
        }
        return -1;
    }

    //方法六：快慢指针法
    public static int findDuplicate6(int[] nums) {
        // 定义快慢指针
        int fast = 0, slow = 0;
        // 1. 寻找环内的相遇点
        do {
            // 快指针一次走两步，慢指针一次走一步
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (fast != slow);

        // 循环结束，slow和fast相等，都是相遇点
        // 2. 寻找环的入口点
        // 另外定义两个指针，固定间距
        int before = 0, after = slow;
        while (before != after){
            before = nums[before];
            after = nums[after];
        }

        // 循环结束，相遇点就是环的入口点，也就是重复元素
        return before;
    }
    public static void main(String[] args) {
//        int[] nums = {1,1};
        int[] nums = { 1,3,4,2,2};
        int num = findDuplicate6(nums);
        System.out.println(num);
    }
}
