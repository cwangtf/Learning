package com.leetcode;

import com.leetcode.utils.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xing_seng
 * @date 2020/8/12
 */
public class LeetCode_133_1 {
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());

        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
