package com.atguigu.algorithm.arrays;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        //思路：从后向前找到升序子序列，然后确定调整后的子序列的最高位，剩余部分升序排列
        int n = nums.length;

        //1.从后向前找到升序子序列，找到第一次下降的数，位置记为k
        int k = n-2;
        while (k>=0&&nums[k]>=nums[k+1]){
            k--;
            System.out.println(k);
        }

        //找到k，就是需要调整位的最高位

        //2.如果k=-1 那么意思就是这个数已经是最大的了，需要将这个数进行倒序排列
        if(k==-1){
            System.out.println("k==-1");
            Arrays.sort(nums);
            return;
        }

        //3.一般情况 k>=0
        //3.1依次遍历剩余降序排列的部分，找到要替换的部分
        int i = k+2;
        while (i<n&&nums[i]>nums[k]){
            i++;
        }

        //当前的i，就是后面部分第一个比nums[k]小的数，i-1就是要被替换的数

        //3.2交换i-1和k位置上的数
        int temp = nums[i-1];
        nums[i-1] = nums[k];
        nums[k] = temp;

        //3.3k之后的剩余部分进行升序排序，直接电换前后顺序
        int start = k+1;
        int end = n-1;
        while (start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        for (int num:nums) {
            System.out.print(num+" ");
        }
    }
}
