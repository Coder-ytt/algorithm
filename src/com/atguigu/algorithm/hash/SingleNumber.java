package com.atguigu.algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SingleNumber {
    //方法一：暴力破解
    public int singleNumber1(int[] nums) {
        int result = nums[0];
        for (int i = 0; i <nums.length ; i++) {
            boolean flag = true;
            for (int j = 0; j <nums.length ; j++) {
                //不与自身比较
                if(i==j){
                    continue;
                }
                if(nums[i]==nums[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result = nums[i];
            }
        }
        return result;
    }

    //方法二：暴力法
    public int singleNumber2(int[] nums) {
        //定义一个列表，保存当前所有出现过一次的元素
        ArrayList<Integer> singleNumList = new ArrayList<>();

        //遍历所有元素
        for (Integer num:nums) {
            if(singleNumList.contains(num)){
                //如果已经出现过,删除列表中的元素
                singleNumList.remove(num);
            }else {
                //没有出现过，直接保存
                singleNumList.add(num);
            }
        }
        return singleNumList.get(0);
    }

    //方法三：保存单独的元素到hashMap
    public int singleNumber3(int[] nums) {
        HashMap<Integer, Integer> singleNumMap = new HashMap<>();

        for (Integer num:nums) {
            if(singleNumMap.get(num)!=null){
                singleNumMap.remove(num);
            }else {
                singleNumMap.put(num,1);
            }
        }
        return singleNumMap.keySet().iterator().next();
    }
    //方法四：用set去重，然后加所有数，乘2，减去一开始的数组和（数学解法）
    public int singleNumber4(int[] nums) {
        //定义一个hashset进行去重
        HashSet<Integer> set = new HashSet<>();
        int arraySum = 0;
        int setSum = 0;
        //1.遍历数组元素，保存到set中，并直接求和
        for (Integer num:nums) {
            set.add(num);
            arraySum+=num;
        }
        //2.集合所有元素求和
        for (int num:set) {
            setSum+=num;
        }

        //3.计算结果
        int result = setSum*2-arraySum;
        return  result;
    }

    //方法五：数学方法（异或）,任意数与自己异或得到0，0与任意数异或得到任意数，思路：所有数进行异或，异或是满足交换律和结合律
    public int singleNumber(int[] nums) {
        //最后的异或结果
        int result = 0;
        //遍历所有数据，按位异或
        for (int num:nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] arr ={2,2,1};
        System.out.println(singleNumber.singleNumber(arr));
    }
}
