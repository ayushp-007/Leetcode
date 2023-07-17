class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = {}
        for i in range(0, numCourses):
            adj[i] = []
        for i in prerequisites:
            adj[i[1]].append(i[0])
        vis1 = [False] * numCourses
        vis2 = [False] * numCourses
        def cycle(node):
            if vis2[node]:
                return True;
            if vis1[node]:
                return False
            vis1[node] = True
            vis2[node] = True
            for i in adj[node]:
                if cycle(i):
                    return True
            vis2[node] = False
            return False
        for i in range(0, numCourses):
            if cycle(i):
                return False
        return True
