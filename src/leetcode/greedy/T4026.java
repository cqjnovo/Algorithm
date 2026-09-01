import Math;

class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int[] suf = new int[n];
        int j = station.length() - 1;
        for (int i = n - 1; i > 0; i--) {
            while (skill.charAt(i) != station.charAt(j)) {
                j--;
            }
            suf[i] = j;
            j--;
        }
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < n - 1; i++) {
            while (skill.charAt(i) != station.charAt(pre)) {
                pre += 1;
            }
            ans = Math.max(ans, suf[i+1] - pre);
            pre += 1;
        }
        return ans;
    }
}