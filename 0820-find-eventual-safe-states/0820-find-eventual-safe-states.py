class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        safe = [False] * n
        vis = [False] * n
        def dfs(node):
            vis[node] = True;
            safe[node] = True
            for i in graph[node]:
                if vis[i] == False and dfs(i) == True:
                    return True
                elif safe[i] == True:
                    return True
            safe[node] = False
            return False
        ans = []
        for i in range(0, n):
            if vis[i] == False:
                dfs(i)
        for i in range(0, n):
            if safe[i] == False:
                ans.append(i)
        return ans