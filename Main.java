import java.util.*;
/*
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:
its length is at least two, and
the sum of the elements of the subarray is a multiple of k.

Note that:
A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.


Example 1:
Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a cont
*/

/*
.................................Explanation ..................................................
* 1. Whenever we see some kind of subarray with sum kind of problem, always try to think HashMap+PrefixSum
* 2. Now in case of subarray sum % k kind of problem, we generally have to play with remainder
* 3. here we are going to maintain (prefixSum % k) in the hashmap, and check for every new prefix sum we already have prefix sum % k in our map or not.
* */

/*
..................................More easier variation of this kind of problem ...................................
1. https://www.techiedelight.com/find-subarray-having-given-sum-given-array/ --> 2nd part Hashing approach.
2. https://www.techiedelight.com/find-subarrays-given-sum-array/ --> see the hashing approach
 */


class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {

    int sum = 0;
    var map = new HashMap<Integer, Integer>();
    map.put(0, -1);
    int i = 0;
    for(int num : nums){
      sum+=num;
      int rem = sum % k;

      //more concise way will be, if(map.getOrDefault(rem, -1) > 0)
      if(map.containsKey(rem) && (i - (map.get(rem)+1)) > 0){
        return true;
      }

      /*
      we wanted to have the subarray with atleast size 2, so if we already have some remainder in out map
      we don't wanted to update it, because it will reduces our chances to find big subarray.
      eg, if our map contains {3 : 1}, and later we can agian 3 at index 8, we need to keep index 3 with index 1, it will maximise our chances to find subarray size greater than 1.
      */
      map.putIfAbsent(rem, i);
      i++;
    }

    return false;
  }
}