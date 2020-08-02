package com.ccl.leetcode;

/**
 * @auther ccl
 * @create 2020/7/26 21:57
 */
public class Solution188 {
    public static void main(String[] args) {
        int [] maxCount = new int[]{1,4,3,6,2,7,9};
        int resule = maxProfit(2, maxCount);
        System.out.println(resule);
    }

    public static int maxProfit(int k, int[] prices){
        int len = prices.length;
        if(prices.length==0){
            return 0;
        }

        if(k>=prices.length/2){
            int result =0;
            for (int i=0;i<prices.length;i++){
                result = Math.max(result,result-prices[i]-prices[i-1]);
            }
            return result;
        }

        int maxCount[][] = new int[k+1][len];
        for(int i=1; i< maxCount.length; i++){
            int balance = -prices[0];
            for(int j = 1; j<len;j++){
                balance = Math.max(maxCount[i-1][j-1] - prices[j-1],balance);
                maxCount[i][j] = Math.max(maxCount[i][j-1],balance + prices[j]);
            }
        }
        return maxCount[k][len-1];
    }
}
