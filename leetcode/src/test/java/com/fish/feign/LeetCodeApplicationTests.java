package com.fish.feign;

import com.fish.feign.study.Solution;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeetCodeApplicationTests {

	@Test
	void contextLoads() {
//		System.out.println(new Solution().fib(5));
		System.out.println(new Solution().fib(5));
	}
	int numWays(int n) {
		if(n<1){
			return 1;
		}
		return 2*numWays(n-1);

	}

}
