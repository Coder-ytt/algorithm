package com.atguigu.algorithm.binary_search;

public class searchMatrix {
    //方法一：确定行号，进行二分查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(target<matrix[0][0]||target>matrix[m-1][n-1]||m==0){
            return false;
        }
        int low = 0;
        int high = matrix[0].length-1;
        for (int i = 0; i <m ; i++) {
            if(target>=matrix[i][0]&&target<=matrix[i][n-1]){
                //那么就当前一行找
                while (low<=high){
                    int mid = (low+high)/2;
                    if(matrix[i][mid]<target){
                        low = mid+1;//取右半部分
                    }else if (matrix[i][mid]>target){
                        high = mid -1;
                    }else {
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }
    //方法二：二维转一维
    public static boolean searchMatrix2(int[][] matrix, int target) {
        //先定义m和n
        int m  = matrix.length;
        if(m==0) return false;
        int n = matrix[0].length;

        //二分查找,定义左右指针
        int left = 0;
        int right = m*n-1;

        while (left<=right){
            //计算中间位置
            int mid = (left+right)/2;
            //计算二位数组中对应的行列号，取出对应元素
            int midElement = matrix[mid/n][mid%n];

            //判断中间元素与target大小关系
            if(midElement<target){
                left = mid+1;
            }else if(midElement>target){
                right = mid-1;
            }else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr ={
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target = 34;
        boolean flag = searchMatrix2(arr,target);
        System.out.println(flag);
    }
}
