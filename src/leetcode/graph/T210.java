package leetcode.graph;

import java.util.*;

/**
 * @description: 课程表Ⅱ
 * @author: lzy
 * @time: 2024/8/27 10:51
 */
public class T210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int p = 0;
        //借助一个队列实现广度优先遍历
        boolean[] learned = new boolean[numCourses];
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer,List<Integer>> outDegree = new HashMap<>();
        //初始化map 其中inDegree保存每门课程的先修课程
        //outDegree 保存每门课程的后序课程
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i,0);
            outDegree.put(i,new ArrayList<>());
        }
        //遍历prerequisites给map赋值
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> outs = outDegree.get(pre);
            outs.add(cur);
            outDegree.put(pre,outs);
            inDegree.put(cur,inDegree.get(cur) + 1);
        }
        //把入度为0的结点入队
        Queue<Integer> queue = new LinkedList<>();
        for (Integer i : inDegree.keySet()) {
            if (inDegree.get(i) == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            learned[cur] = true;
            res[p++] = cur;
            for (int x : outDegree.get(cur)) {
                int cnt = inDegree.get(x);
                cnt -= 1;
                if (cnt == 0) {
                    queue.offer(x);
                } else {
                    inDegree.put(x,cnt);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!learned[i]) {
                return new int[] {};
            }
        }
        return res;
    }
}
