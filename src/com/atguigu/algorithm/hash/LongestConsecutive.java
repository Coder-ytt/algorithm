package com.atguigu.algorithm.hash;

import java.util.HashSet;

public class LongestConsecutive {
    //1.暴力法
    public int longestConsecutive1(int[] nums) {
        //定义一个变量，保存当前最长连续序列的长度
        int maxLength = 0;

        //遍历数组，以每个元素作为起始点，寻找连续序列
        for (int i = 0; i <nums.length ; i++) {
            //保存当前元素作为起始点
            int currNum = nums[i];
            //保存当前连续序列长度
            int currLength = 1;

            //寻找后续数字，组成连续序列
            while (contains(nums,currNum+1)){
                currLength++;
                currNum++;
            }

            //判断当前连续序列长度与最大值比较
            maxLength = currLength>maxLength?currLength:maxLength;
        }
        return maxLength;
    }
    //定义一个方法，用于寻找数组中某个元素
    public static boolean contains(int[] nums,int x){
        for (int  num:nums) {
            if(num==x){
                return true;
            }
        }
        return false;
    }

    //方法二：利用hashmap存储数组
    public int longestConsecutive2(int[] nums) {
        //定义一个变量，保存当前最长连续序列的长度
        int maxLength = 0;

        //定义一个hashset，保存所有出现的数值
        HashSet<Integer> hashSet = new HashSet<>();

        //1.遍历所有元素 保存到hashset内
        for(int num:nums){
            hashSet.add(num);
        }

        //2.遍历数组，以每个元素作为起始点，寻找连续序列
        for (int i = 0; i <nums.length ; i++) {
            //保存当前元素作为起始点
            int currNum = nums[i];
            //保存当前连续序列长度
            int currLength = 1;

            //寻找后续数字，组成连续序列
            while (hashSet.contains(currNum+1)){
                currLength++;
                currNum++;
            }

            //判断当前连续序列长度与最大值比较
            maxLength = currLength>maxLength?currLength:maxLength;
        }
        return maxLength;
    }
    //方法三：利用hashmap存储数组改进
    public int longestConsecutive(int[] nums) {
        //定义一个变量，保存当前最长连续序列的长度
        int maxLength = 0;

        //定义一个hashset，保存所有出现的数值
        HashSet<Integer> hashSet = new HashSet<>();

        //1.遍历所有元素 保存到hashset内
        for(int num:nums){
            hashSet.add(num);
        }

        //2.遍历数组，以每个元素作为起始点，寻找连续序列
        for (int i = 0; i <nums.length ; i++) {
            //保存当前元素作为起始点
            int currNum = nums[i];
            //保存当前连续序列长度
            int currLength = 1;

            //追加一个条件，判断：只有当前前驱不存在的情况下，才去进行寻找连续序列操作
            if(!hashSet.contains(currNum-1)){
                //寻找后续数字，组成连续序列
                while (hashSet.contains(currNum+1)){
                    currLength++;
                    currNum++;
                }

                //判断当前连续序列长度与最大值比较
                maxLength = currLength>maxLength?currLength:maxLength;
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }
}
