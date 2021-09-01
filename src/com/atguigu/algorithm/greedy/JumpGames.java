package com.atguigu.algorithm.greedy;

public class JumpGames {

    //方法一：暴力，遇到0的时候就去判断一下前面的数是否可以跳过这个0，如果最后一个数是0，判断是否可以刚好到达或者跳跃该数
    public boolean canJump1(int[] nums) {
        if(nums[0]==0&&nums.length!=1) return false;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]==0){
                //写一个方法判断这个0是否可以跳跃过去
                boolean fl = flag(nums,i);
                if(fl){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean flag(int[] nums,int m){
        for (int i = 0; i <m; i++) {
            if(i+nums[i]>m){
                return true;
            }else if(m==nums.length-1&&i+nums[i]>=m){
                return true;
            }
        }
        return false;
    }

    //方法二：贪心策略
    public boolean canJump(int[] nums) {
        //定义一个变量，保存当前最远能跳到的位置
        int farthest = 0;
        //遍历数组，更新farthest
        for (int i = 0; i <nums.length ; i++) {
            //判断当前i在可到达的范围内，更新farthest
            if(i<=farthest){
                farthest = Math.max(farthest,i+nums[i]);
                if(farthest>=nums.length-1){
                    return true;
                }
            } else{
                //如果i已经到不了
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        JumpGames jumpGames = new JumpGames();
        System.out.println(jumpGames.canJump(nums));
    }
}
