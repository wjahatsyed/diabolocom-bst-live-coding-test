package bstpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BST {
    public static Integer findMinimumGreaterThanValue(TreeNode root, int num) {
        Integer successor = null;
        while (root != null) {
            if (root.value > num) {
                successor = root.value;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }
    //O(n log K)
    public static List<Integer> findMinimumKGreaterThanValue(TreeNode root, int num, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || k <= 0) {
            return result;
        }
        //O(log k)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        inorderTraversal(root, num, maxHeap, k);

        while(!maxHeap.isEmpty()){
            result.add(maxHeap.poll());
        }
        Collections.reverse(result);
        return result;

    }
    //O(n)
    private static void inorderTraversal(TreeNode node, int num, PriorityQueue<Integer> maxHeap, int k) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, num, maxHeap, k);

        if (node.value > num) {
            if (maxHeap.size() < k) {
                maxHeap.offer(node.value);
            } else {
                if (node.value < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(node.value);
                }
            }
        }
        inorderTraversal(node.right, num, maxHeap, k);
    }
}


