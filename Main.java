import java.util.*;
/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
A subarray is a contiguous part of an array.



Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0


Constraints:
1 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
2 <= k <= 10^4
*/

/*
.................................Explanation ..................................................
*
1. Main idea here to think about how to handle the negative number, its pretty similar to count number of subarray with sum k kind of problem.
2. Main algo is if A = [1, 2, -3, 3], if we keep maintaining a prefix sum, at index 2 we get sum 0, have seen 0 before? if yes then we found a subarray with 0 sum.
3. Same idea can applied to more generic case like subarray with sum k
*/

/*
..................................More easier variation of this kind of problem(these are roots algo for such kind of problem) ...................................
1. https://www.techiedelight.com/find-subarray-having-given-sum-given-array/ --> 2nd part Hashing approach.
2. https://www.techiedelight.com/find-subarrays-given-sum-array/ --> see the hashing approach
*/

class Solution {
  public int subarraysDivByK(int[] nums, int k) {

    int[] count = new int[k];
    count[0] = 1;
    int n = nums.length;
    int ans = 0;

    int sum = 0;
    for(int num : nums){
      //extra +k will help us handle negative remainder
      sum = (sum + num % k + k) % k;
      ans+=count[sum];
      count[sum]++;
    }

    return ans;
  }
}