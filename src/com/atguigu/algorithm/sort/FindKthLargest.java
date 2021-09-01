package com.atguigu.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class FindKthLargest {
    //方法一：直接排序(调库)
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //方法二：基于快排的选择
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }

    public int quickSelect(int[] nums, int start, int end, int index) {
        //找到基准pivot位置返回
        int position = randomPatition(nums,start,end);

        //判断当前pivot位置是否为index
        if(position == index){
            return nums[position];
        }else {
            return position>index?quickSelect(nums,start,position-1,index):quickSelect(nums,position+1,end,index);
        }
    }

    //随机分区的方法
    public int randomPatition(int[] nums, int start, int end) {
        Random random = new Random();
        int randIndex = start+random.nextInt(end-start+1);
        swap(nums,start,end);
        return partition(nums,start,end);
    }
    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start,right = end;

        while (left<right){
            //左移右指针，找到一个比pivot小的数，填入空位
            while (left<right&&nums[right]>=pivot){
                right--;
            }
            nums[left] = nums[right];
            while (left<right&&nums[left]<=pivot){
                left++;
            }
            nums[right]  = nums[left];
        }
        nums[left] = pivot;

        return left;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    //方法三：基于堆排序的选择
    public int findKthLargest(int[] nums, int k) {
        int  n = nums.length;
        //保存堆的大小，初始就是n
        int heapSize = n;

        //1.构建大顶堆
        buildMaxHeap(nums,heapSize);

        //2.执行n-1次删除堆顶元素操作
        for (int i = n-1; i >n-k ; i--) {
            //将堆顶元素交换到当前堆的末尾
            swap(nums,0,i);
            heapSize--;
            maxHeapify(nums,0,heapSize);
        }

        //3.返回当前堆顶元素
         return nums[0];
    }

    //定义一个调整成大顶堆的方法
    public void maxHeapify(int[] nums, int top, int heapSize) {
        //定义左右子节点
        int left = top*2+1;
        int right = top*2+2;

        //保存当前最大元素的索引位置
        int largest = top;

        //比较左右子节点,记录最大元素索引位置
        if(right<heapSize&&nums[right]>nums[largest]){
            largest = right;
        }

        if(left<heapSize&&nums[left]>nums[largest]){
            largest = left;
        }

        //将最大元素换到堆顶
        if(largest!=top){
            swap(nums,top,largest);
            //递归调用，继续下沉
            maxHeapify(nums,largest,heapSize);
        }
    }

    //构建大顶堆
    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize/2-1; i >=0 ; i--) {
            maxHeapify(nums,i,heapSize);
        }
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = {3,2,3,1,2,4,5,5,6};
//        int[] nums = {3,2,1,5,6,4};
        int k = 4;
        System.out.println(findKthLargest.findKthLargest(nums,k));
    }
}
