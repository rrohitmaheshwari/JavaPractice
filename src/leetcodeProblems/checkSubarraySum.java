/*
523. Continuous Subarray Sum
https://leetcode.com/problems/continuous-subarray-sum/
O(N)
O(N)
*/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
	Map<Integer, Integer> map = new HashMap<>();
	map.put(0, -1);
	int sum = 0;
	for(int i = 0; i < nums.length; i++){
		sum += nums[i];
		int mod = sum % k;
		if(i - map.getOrDefault(mod, i) >= 2) return true;
		map.putIfAbsent(mod, i);
	}
	return false;
}
}