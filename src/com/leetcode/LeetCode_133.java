package com.leetcode;

import com.leetcode.utils.Node;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 133. 克隆图(medium)
 * https://leetcode-cn.com/problems/clone-graph
 * 一、DFS，时间复杂度O(N)，空间复杂度O(N)
 * 二、BFS，时间复杂度O(N)，空间复杂度O(N)，待练习
 *
 * @author xing_seng
 * @date 2020/8/12
 */
public class LeetCode_133 {
    private HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // 哈希表存储
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for(Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
