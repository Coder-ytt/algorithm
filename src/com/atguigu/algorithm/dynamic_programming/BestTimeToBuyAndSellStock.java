package com.atguigu.algorithm.dynamic_programming;

public class BestTimeToBuyAndSellStock {
    //方法一：暴力破解
    public static int maxProfit1(int prices[]) {
        int maxProfit = 0;
        //遍历所有可能的买入卖出的情况
        for (int i = 0; i <prices.length-1 ; i++) {
            for (int j = i;j<prices.length;j++){
                int currProfit = prices[j]-prices[i];
                maxProfit = Math.max(maxProfit,currProfit);
            }
        }
        return maxProfit;
    }

    //方法二：动态规划
    public static int maxProfit(int prices[]) {
        //定义状态：保存到目前为止最小价格，和最大利润
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        //遍历数组元素 ，以当前价格作为卖出点进行比较
        for (int i = 0; i <prices.length ; i++) {
            minPrice = Math.min(minPrice,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }
}
