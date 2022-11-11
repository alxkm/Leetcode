package com.leetcode.easy.sort;

import java.util.Arrays;

public class _628_Maximum_Product_of_Three_Numbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        boolean negative = true;
        boolean positive = true;
        for (int n : nums) {
            if (n < 0) positive = false;
            if (n > 0) negative = false;
        }

        if (negative || positive) {
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        }

        int f = 0;
        int s = 0;
        int ind = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int a = Math.max(Math.abs(f), Math.abs(nums[i]));
                if (f != a) {
                    f = a;
                    ind = i;
                }
            }
        }

        int counter = 0;

        for (int num : nums) {
            if (f == num) {
                counter++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (i != ind) {
                    int a = Math.max(Math.abs(s), Math.abs(nums[i]));
                    if (s != a) {
                        s = a;
                    }
                }
            }
        }
        int sub1 = 0;
        if (counter == 2) sub1 = f * f * nums[nums.length - 1];

        int sub2 = f * s * nums[nums.length - 1];
        int sub3 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        int max = Math.max(sub1, sub2);
        max = Math.max(sub2, sub3);

        return max;
    }
}
