class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        f1 = [0] * 26
        f2 = [0] * 26
        for i in s: 
            f1[ord(i) - ord('a')] += 1
        for i in goal:
            f2[ord(i) - ord('a')] += 1
        if f1 != f2:
            return False
        cnt = 0
        two = False
        for i, j in zip(s, goal):
            if not i == j:
                cnt += 1
            if f1[ord(i) - ord('a')] >= 2:
                two = True
        if cnt == 0:
            return two
        return cnt == 2