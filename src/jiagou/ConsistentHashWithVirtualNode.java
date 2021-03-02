package jiagou;

import java.util.*;

/**
 * 带虚拟节点的一致性hash
 *
 * @author wangtf
 * @date 2020/7/5
 */
public class ConsistentHashWithVirtualNode {

    private String[] serversArr;

    /** 真实服务器节点 */
    private List<String> realNodes = new LinkedList<>();

    /** 虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点名称 */
    private SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    /** 服务器访问统计 */
    private TreeMap<String, Integer> serverVisit = new TreeMap<>();

    /** 虚拟节点数量 */
    private int virtualNodesNum;

    public ConsistentHashWithVirtualNode(String[] servers, int virtualNodesNum) {
        this.serversArr = servers;
        this.virtualNodesNum = virtualNodesNum;
    }

    /**
     * 把原始服务器添加到真实节点列表中
     */
    public void addServer() {
        realNodes.addAll(Arrays.asList(serversArr));
    }

    /**
     * 添加虚拟节点
     */
    public void addVirtualNode() {
        for (String node : realNodes) {
            if (!serverVisit.containsKey(node)) {
                serverVisit.put(node, 0);
                for (int i = 0; i < this.virtualNodesNum; i++) {
                    int hash = getHash(node + "&VN" + i);
                    virtualNodes.put(hash, node);
                }
            }
        }
    }

    /**
     * 获取访问统计
     */
    public void getServerVisit() {
        for (Map.Entry<String, Integer> entry : serverVisit.entrySet()) {
            System.out.println("服务器节点：" + entry.getKey() + ",命中数量:" + entry.getValue());
        }
    }

    /**
     * FNV1_32_HASH算法
     *
     * @param str 计算字符
     * @return int
     */
    private static int getHash(String str){
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        return hash;
    }

    public void getServer(String key) {
        // 获取key的hash值
        int hash = getHash(key);
        // 获取大于改hash值的所有Map
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        // 虚拟节点
        String virtualNode;
        if (subMap.isEmpty()) {
            // 为空，获取第一个node
            virtualNode = virtualNodes.get(virtualNodes.firstKey());
        } else {
            // 不为空，找顺时针第一个节点
            virtualNode = virtualNodes.get(subMap.firstKey());
        }
        // 记录访问次数
        serverVisit.put(virtualNode, serverVisit.get(virtualNode) + 1);
    }

    /**
     * 求标准差
     *
     * @return double
     */
    public double getStd() {
        Integer[] visitData = new Integer[serverVisit.size()];
        serverVisit.values().toArray(visitData);
        double avg = Arrays.stream(visitData).mapToInt(Integer::intValue).average().orElse(0d);
        double avgStd = Arrays.stream(visitData).map(count -> Math.pow(count - avg, 2)).mapToDouble(Double::doubleValue).average().orElse(0d);
        return Math.sqrt(avgStd);
    }

    public static void main(String[] args) {
        // 模拟100万数据
        int count = 1000000;
        // 10个服务器节点
        String[] servers = {
                "192.168.0.0:8080",
                "192.168.0.1:8080",
                "192.168.0.2:8080",
                "192.168.0.3:8080",
                "192.168.0.4:8080",
                "192.168.0.5:8080",
                "192.168.0.6:8080",
                "192.168.0.7:8080",
                "192.168.0.8:8080",
                "192.168.0.9:8080"
        };
        // 虚拟节点数量100、200、500
        int[] virtualNums = new int[]{100, 200, 500};
        for (int virtualNum : virtualNums) {
            ConsistentHashWithVirtualNode consistentHashWithVirtualNode = new ConsistentHashWithVirtualNode(servers, virtualNum);
            consistentHashWithVirtualNode.addServer();
            consistentHashWithVirtualNode.addVirtualNode();
            for (int i = 0; i < count; i++) {
                consistentHashWithVirtualNode.getServer(UUID.randomUUID().toString());
            }
            consistentHashWithVirtualNode.getServerVisit();
            System.out.println("虚拟节点数量：" + virtualNum + ",标准差：" + consistentHashWithVirtualNode.getStd());
            System.out.println("-------------------------------------------");
        }
    }
}
