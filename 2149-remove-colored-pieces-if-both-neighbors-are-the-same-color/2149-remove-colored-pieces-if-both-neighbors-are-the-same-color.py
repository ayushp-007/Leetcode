class Solution:
    def winnerOfGame(self, colors: str) -> bool:
        cntA = 0
        cntB = 0
        for i in range(1, len(colors) - 1):
            if colors[i - 1] == colors[i] == colors[i + 1]:
                if colors[i] == 'A':
                    cntA += 1
                if colors[i] == 'B':
                    cntB += 1
        return cntA > cntB