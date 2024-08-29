package leetcode.unionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 除法求值
 * 使用并查集-建立每个点与根节点的系数关系
 * 如果两个点位于同一个连通图，则可以通过一步除法操作获取答案
 * @author: lzy
 * @time: 2024/8/29 10:55
 */
class UnionFind {
    //记录每个节点的根节点
    public Map<String,String> father = null;
    //记录结点与根节点的系数
    public Map<String,Double> value = null;

    public UnionFind() {
        father = new HashMap<>();
        value = new HashMap<>();
    }

    /**
     * 新增结点
     * @param x
     */
    public void add(String x) {
        if (!father.containsKey(x)) {
            father.put(x,null);
            value.put(x,1.0);
        }
    }

    /**
     * 1.查找当前结点的根; 2.压缩当前结点到根节点路径上所有结点,使其father,value转为根节点的关系
     */
    public String find(String x) {
        String root = x;
        double base = 1.0;
        //root为x的根结点
        while (father.get(root) != null) {
            root = father.get(root);
            base *= value.get(root);
        }
        //压缩x到根路径上 每个节点与根的系数关系
        while (!x.equals(root)) {
            String originFather = father.get(x);
            father.put(x,root);
            value.put(x,value.get(x) * base);
            x = originFather;
            base /= value.get(originFather);
        }
        return root;
    }

    /**
     * merge (a,b) 2
     * 合并两个点 => 令father[b] = a, value[b] = 2
     */
    public void merge(String x, String y, double val) {
        String root_x = find(x);
        String root_y = find(y);
        if (!root_x.equals(root_y)) {
            father.put(root_y,root_x);
            value.put(root_y,val * value.get(x) / value.get(y));
        }
    }

    /**
     * 判断两个点是否联通
     */
    public boolean isConnected(String x, String y) {
        return value.containsKey(x) && value.containsKey(y) && find(x).equals(find(y));
    }
}
public class T399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] res = new double[n];
        Arrays.fill(res,-1.0);
        UnionFind uf = new UnionFind();
        for (int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            uf.add(x);
            uf.add(y);
            uf.merge(x,y,values[i]);
        }
        for (int i = 0; i < n; i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (uf.isConnected(x,y)) {
                res[i] = uf.value.get(y) / uf.value.get(x);
            }
        }
        return res;
    }
}
