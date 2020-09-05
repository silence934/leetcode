package xyz.nyist.writerTest.xiecheng;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author : fucong
 * @Date: 2020-08-15 19:30
 * @Description :
 */
class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);

        for (String nodeValue : value.split("\\|")) {
            String[] properties = nodeValue.split("`");
            WorkflowNode node = map.get(properties[0]);

            node.timeoutMillis = Integer.parseInt(properties[1]);
            node.initialised = true;

            // Check next nodes
            if ("END".equals(properties[2])) {
                continue;
            }
            node.nextNodes = Arrays.stream(properties[2].split(","))
                    .map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));

            map.put(node.nodeId, node);
        }

        return head;
    }

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }

}


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            try {
                WorkflowNode node = WorkflowNode.load(cin.next());
                if (node.nextNodes == null || node.nextNodes.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(test(node));
                }
            } catch (Exception e) {
                System.out.println(-1);
            }
        }
    }

    private static int test(WorkflowNode node) {
        if (node.nextNodes == null || node.nextNodes.isEmpty()) {
            return node.timeoutMillis;
        }
        int max = Integer.MIN_VALUE;
        for (WorkflowNode nextNode : node.nextNodes) {
            max = Math.max(max, test(nextNode));
        }
        return max + node.timeoutMillis;
    }
}
