package leetcode.graph;

import java.util.*;

/**
 * @description: 课程表
 * @author: lzy
 * @time: 2024/8/27 9:14
 */
public class T207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //借助一个队列实现广度优先遍历
        boolean[] learned = new boolean[numCourses];
        Map<Integer,List<Integer>> inDegree = new HashMap<>();
        Map<Integer,List<Integer>> outDegree = new HashMap<>();
        //初始化map 其中inDegree保存每门课程的先修课程
        //outDegree 保存每门课程的后序课程
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i,new ArrayList<>());
            outDegree.put(i,new ArrayList<>());
        }
        //遍历prerequisites给map赋值
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> outs = outDegree.get(pre);
            List<Integer> ins = inDegree.get(cur);
            ins.add(pre);
            outs.add(cur);
            outDegree.put(pre,outs);
            inDegree.put(cur,ins);
        }
        //把入度为0的结点入队
        Queue<Integer> queue = new LinkedList<>();
        for (Integer i : inDegree.keySet()) {
            if (inDegree.get(i).size() == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            learned[cur] = true;
            for (int x : outDegree.get(cur)) {
                List<Integer> pres = inDegree.get(x);
                pres.remove(cur);
                if (pres.size() == 0) {
                    queue.offer(x);
                } else {
                    inDegree.put(x,pres);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!learned[i]) {
                return false;
            }
        }
        return true;
    }
}
