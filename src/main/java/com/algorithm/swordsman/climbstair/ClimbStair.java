package com.algorithm.swordsman.climbstair;

import java.util.Stack;

/**
 * 假设你现在正在爬楼梯，楼梯有 n 级。每次你只能爬 1级或者 2级，那么你有多少种方法爬到楼梯的顶部？
 * 该问题  等同于斐波那契数列问题
 * @author lix
 *
 */
public class ClimbStair {

	/**
	 * 最简单的递归
	 * @param a
	 * @return
	 */
	static int Climb(int a) {
		if(a<=2) {
			return a;
		}
		return Climb(a-1)+Climb(a-2);
	}
	
	static int Climb2(int a) {
		if(a<=2) {
			return a;
		}
		else {
			int first = 1;
			int second = 2;
			int temp = 0;
			for (int i = 3; i <= a; i++) {
				temp = first + second;
				first = second;
				second = temp;
			}
			return temp;
		}
	}
	
	/**
	 * 展示明细的步数
	 * @param st
	 * @param n
	 */
	static void buildT(Stack<Integer> st,int n) {
		if(n>=1) {
			st.push(1);
			buildT(st,n-1);
			st.pop();
		}
		if(n>=2) {
			st.push(2);
			buildT(st,n-2);
			st.pop();
		}
		if(n==0) {
			for (int i : st) {
				System.out.println("Step:" + i + "-->");
			}
		}
	}
	public static void main(String[] args) {
//		System.out.println(Climb(8));
//		Stack<Integer> st = new Stack<>();
//		buildT(st, 8);
		System.out.println(Climb2(8));
	}
}
