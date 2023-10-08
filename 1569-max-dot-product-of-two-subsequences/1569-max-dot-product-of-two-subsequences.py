class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1)
        m = len(nums2)
        inf = 1e9

        dp = [[[None] * (2) for _ in range(m)] for _ in range(n)]

        def recur(i, j, k):
            if i == n or j == m:
                if k == 1:
                    return 0
                return -inf

            if dp[i][j][k] != None:
                return dp[i][j][k]

            ans = -inf
            ans = max(ans, nums1[i] * nums2[j] + recur(i + 1, j + 1, 1))
            ans = max(ans, max(recur(i + 1, j ,k), recur(i, j + 1, k)))

            dp[i][j][k] = ans

            return dp[i][j][k]
        
        return recur(0, 0, 0)