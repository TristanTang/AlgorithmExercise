/**
 * @program: AlgorithmExercise
 * @description: 938.Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).  The binary search tree is guaranteed to have unique values.
 * @author: TangWang
 * @create: 2019-11-11 10:25
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
 * Memory Usage: 45.6 MB, less than 97.67% of Java online submissions for Range Sum of BST.
 **/
public class RangeSumOfBST {

    /***
     * @description 递归思路
     * @param root 根节点
     * @param L 数字范围左边界
     * @param R 数字范围右边界
     * @return int 总和
     * @author TangWang
     * @date 2019/11/11 10:28
     */
    public int method1(TreeNode root, int L, int R) {
        int result = 0;
        if(root!=null) {
            if(root.val>=L && root.val<=R) {
                result += root.val;
            }
            if(root.val>L) {
                result += rangeSumBST(root.left, L, R);
            }
            if(root.val<R) {
                result += rangeSumBST(root.right, L, R);
            }
        }
        return result;
    }

    public int rangeSumBST(TreeNode root, int L, int R){
        return method1(root, L, R);
    }

    public static void main(String[] args) {

    }
}

/***
 * @description 树节点
 * @author TangWang
 * @date 2019/11/11 10:27
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}