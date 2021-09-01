package com.atguigu.algorithm.greedy;

public class JumpGames2 {
    //方法一：反向跳跃
    public int jump1(int[] nums) {
        //定义一个变量保存跳跃步数
        int steps = 0;

        //定义循环变量
        int currPosition = nums.length-1;

        //不停的向前跳跃，以最远的距离
        while (currPosition>0){
            //从前到后遍历数组元素，找到当前距离最远的“上一步位置”
            for (int i = 0; i <currPosition ; i++) {
                if(i+nums[i]>=currPosition){{
                    currPosition = i;//从前到后，第一次能跳到当前位置的位置，就是最远的上一步位置
                    steps++;
                    break;
                }}
            }
        }
        return steps;
    }


    //方法二：正向跳跃,考虑能够跳到最远的两步
    public int jump2(int[] nums) {
        //处理特殊场景
        if(nums.length==1) return 0;
        //定义一个变量保存跳跃步数
        int steps = 0;
        int currPosition = 0;

        //定义双指针，指向当前位置跳一步和两步分别能到的最远位置
        int farthest = nums[0];
        int nextFarthest = farthest;

        //不停贪心寻找下一步的合适位置
        while (farthest<nums.length-1){
            //遍历currPosition-farthest范围所有元素，选择第二步跳跃最远的作为当前一步的选择
            for (int i = 0; i <=farthest; i++) {
                //如果比之前第二部最远距离大，就更新
                if(i+nums[i]>nextFarthest){
                    nextFarthest = i+nums[i];
                    currPosition = i;
                }
            }
            //当前一步完成
            steps++;
            farthest = nextFarthest;
        }
        return ++steps;

    }


    //方法三：正向跳跃,优化
    public int jump(int[] nums) {
        //处理特殊场景
        if(nums.length==1) return 0;
        //定义一个变量保存跳跃步数
        int steps = 0;

        //定义双指针，指向当前位置跳一步和两步分别能到的最远位置
        int farthest = nums[0];
        int nextFarthest = farthest;

        //遍历currPosition-farthest范围所有元素，选择第二步跳跃最远的作为当前一步的选择
        for (int i = 0; i <nums.length-1; i++) {
            //如果比之前第二部最远距离大，就更新
            if(i+nums[i]>nextFarthest){
                nextFarthest = i+nums[i];
            }
            //添加步数增长条件，处理到farthest
            if(i==farthest){
                steps++;
                farthest = nextFarthest;
            }
        }
        return ++steps;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        JumpGames2 jumpGames2 = new JumpGames2();
        System.out.println(jumpGames2.jump(nums));
    }
}
