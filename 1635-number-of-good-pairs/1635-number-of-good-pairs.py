class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        dict = collections.Counter()
        ans = 0
        for i in nums:
            ans += dict[i]
            dict[i] += 1
        return ans