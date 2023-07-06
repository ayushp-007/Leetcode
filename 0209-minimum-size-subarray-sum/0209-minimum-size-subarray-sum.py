class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        pre = [0] * n
        pre[0] = nums[0]
        for i in range(1, n):
            pre[i] = pre[i - 1] + nums[i]
        l = 0
        r = 0
        ans = 10 ** 20
        while l <= r and r < n:
            if pre[r] - pre[l] + nums[l] >= target:
                ans = min(ans, r - l  + 1)
                l += 1
            else:
                r += 1
        if ans == 10 ** 20:
            return 0
        return ans