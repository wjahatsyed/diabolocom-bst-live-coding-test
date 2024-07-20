package testing;

import bstpackage.BST;
import bstpackage.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BSTTests {
    /*
        10
          /    \
        5       15
      /  |      /  \
     2   7    12   17
     */
    @Test
    void testFindMinimumGreaterThanValue() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(17);

        //n=16
        assertEquals(17, BST.findMinimumGreaterThanValue(root, 16));
        //n=6
        assertEquals(7, BST.findMinimumGreaterThanValue(root, 6));
    }

    @Test
    void testFindMinimumKGreaterThanValue(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(17);

        //n=16 k =4
        System.out.println(BST.findMinimumKGreaterThanValue(root, 6, 4));
    }
}
