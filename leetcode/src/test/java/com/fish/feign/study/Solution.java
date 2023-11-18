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
        int[] f = new int[n+2 ];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
            f[i] %= 1000000007;
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(2));
    }
}
