package com.atguigu.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    //测试
    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};

        ThreeSum threeSum = new ThreeSum();

        System.out.println(threeSum.threeSum3(input));

    }
    /**
     * 方法一：暴力破解  未去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        //定义结果列表
        List<List<Integer>> result = new ArrayList<>();

        //三重for循环 枚举所有的三数组合
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j <n-1 ; j++) {
                for (int k = j+1; k < n; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return  result;
    }

    /**
     * 方法二：使用哈希表保存结果  未去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums){
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        // 定义一个hash map
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // 遍历数组，寻找每个数对应的那个数
        for( int i = 0; i < n; i++ ){
            int thatNum = 0 - nums[i];
            if (map.containsKey(thatNum)){
                // 如果已经存在thatNum，就找到了一组解
                ArrayList<Integer> tempList = new ArrayList<>(map.get(thatNum));
                tempList.add(nums[i]);
                result.add(tempList);
            }

            // 把当前数对应的两数组合都保存到map里
            for (int j = 0; j < i; j++ ){
                // 以两数之和作为key
                int newKey = nums[i] + nums[j];
                // 如果key不存在，就直接添加进去
                if (!map.containsKey(newKey)){
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    map.put( newKey, tempList );
                }
            }
        }
        return result;
    }

    /**
     * 方法三：双指针法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        int n = nums.length;
        //定义结果列表
        List<List<Integer>> result = new ArrayList<>();

        //1.先对数组进行排序
        Arrays.sort(nums);  //O(nlog(n))

        //2.遍历每一个元素，作为当前三元组中最小的，定义左右指针  时间复杂度O(n^2)
        for (int i = 0; i < n; i++) {
            //2.1 如果当前最小元素大于0，直接退出循环
            if(nums[i]>0)break;

            //2.2 如果当前数出现过，pass
            if(i>0&&nums[i]==nums[i-1]) continue;

            //2.3 定义左右指针
            int lp = i+1;
            int rp = n-1;

            //2.4 只要左指针保持小于右指针 继续移动指针
            while (lp<rp){
                int sum = nums[i]+nums[lp]+nums[rp];
                //判断sum的值，和0进行比较
                if(sum==0){
                    //2.4.1 sum==0 满足条件
                    result.add(Arrays.asList(nums[i],nums[lp],nums[rp]));
                    //左指针右移 右指针左移
                    lp++;
                    rp--;
                    //如果移动后的元素相同 直接跳过
                    while (lp<rp&&nums[lp]==nums[lp-1])lp++;
                    while (lp<rp&&nums[rp]==nums[rp+1])rp--;
                }else if(sum<0){
                    //2.4.2 小了  故左指针右移
                    lp++;
                }else {
                    //2.4.3 大了  故右指针左移
                    rp--;
                }
            }
        }
        return  result;
    }
}
