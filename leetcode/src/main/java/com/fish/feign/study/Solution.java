package com.fish.feign.study;

/**
 * 斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * @author fish
 */
public class Solution {
    public int fib(int n) {
        if(n == 0){ return 0;}
        int[] dp = new int[n+2 ];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    int numWays(int n) {
        int con=1000000007;
//        return fbnq(n+1);
        if(n <= 1) {
            return 1;
        }else if(n == 2) {
            return 2;
        }else {
            return numWays(n-1)%con + numWays(n-2)%con;

        }
    }
    //斐波那契数列
    int fbnq(int n) {
        int con=1000000007;
        int first=0;
        int second=1;
        int tem=0;
        while(n-->0)
        {
            tem=first+second;
            first=second%con;
            second=tem%con;
        }
        return first;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().fib(2));
        System.out.println(new Solution().numWays(0));
    }
}
