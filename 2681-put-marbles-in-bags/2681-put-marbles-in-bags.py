class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        a = []
        n = len(weights)
        for i in range(0, n-1):
            a.append(weights[i] + weights[i + 1])
        a.sort()
        mx = 0
        mn = 0
        for i in range(0, k - 1):
            mn += a[i]
        idx = n - 2
        for i in range(0, k - 1):
            mx += a[idx]
            idx -= 1
        return mx - mn