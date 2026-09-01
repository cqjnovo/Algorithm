class Solution:
    def maximumGap(self, skill: str, station: str) -> int:
        n = len(skill)
        suf = [0] * n
        # 从后往前找子序列
        j = len(station) - 1
        for i in range(n-1, 0, -1):
            while skill[i] != station[j]:
                j -= 1
            suf[i] = j
            j -= 1
        # 从前往后找前部分子序列
        pre = 0
        ans = 0
        for i in range(n-1):
            while skill[i] != station[pre]:
                pre += 1
            ans = max(ans, suf[i+1] - pre)
            pre += 1
        return ans
        