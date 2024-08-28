package leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @description: 克隆图
 * @author: lzy
 * @time: 2024/8/28 9:24
 */


public class T133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node res = null;
        boolean[] visited = new boolean[101];
        //源结点 和 拷贝结点的映射
        Map<Node,Node> map = new HashMap<>();
        //广度优先遍历图，在遍历的过程中进行克隆
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (visited[cur.val]) {
                continue;
            }
            visited[cur.val] = true;
            Node copyCur = null;
            if (!map.containsKey(cur)) {
                copyCur = new Node(cur.val);
                res = copyCur;
                map.put(cur,copyCur);
            } else {
                copyCur = map.get(cur);
            }
            //复制结点的邻居 赋值为 当前结点的邻居
            for (Node neigh : cur.neighbors) {
                //已复制结点直接从map中取，没赋值结点则新建
                if (!map.containsKey(neigh)) {
                    Node copyNeigh = new Node(neigh.val);
                    map.put(neigh,copyNeigh);
                    copyCur.neighbors.add(copyNeigh);
                } else {
                    copyCur.neighbors.add(map.get(neigh));
                }
                if (!visited[neigh.val]) {
                    queue.offer(neigh);
                }
            }
        }
        return res;
    }
}
