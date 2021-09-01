package com.atguigu.algorithm.binary_search;

public class BinarySearch {
    public static int binarySearch(int[] a,int key){
        int low = 0;
        int high = a.length-1;

        //排除特殊情况
        if(key<a[low]||key>a[high]){
            return -1;
        }

        while (low<=high){
            int mid = (low+high)/2;
            if(a[mid]<key){
                low = mid+1;//取右半部分
            }else if (a[mid]>key){
                high = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    //递归实现二分查找,增加搜索的上下界作为参数
    public static int binarySearch2(int[] a,int key,int fromIndex,int toIndex){
        //基本判断,当起始位置大于结束位置时，直接返回-1。特殊情况，如果超出最大最小值，直接返回-1
        if(fromIndex>toIndex||key<a[fromIndex]||key>a[toIndex]){
            return -1;
        }

        //计算中间位置
        int mid = (fromIndex+toIndex)/2;

        //判断中间位置元素和key的大小关系,更改搜索范围,递归调用
        if(a[mid]<key){
            return binarySearch2(a,key,mid+1,toIndex);
        }else if(a[mid]>key){
            return binarySearch2(a,key,fromIndex,mid-1);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};
        int key = 6;
        int index = binarySearch(arr,key);
        int index2 = binarySearch2(arr,key,0,arr.length-1);
        System.out.println(index);
        System.out.println(index2);
    }
}
