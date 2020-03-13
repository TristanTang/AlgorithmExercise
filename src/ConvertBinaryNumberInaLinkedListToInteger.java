/**
 * @program: AlgorithmExercise
 * @description: 1290.Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.  Return the decimal value of the number in the linked list.
 * @author: TangWang
 * @create: 2020-01-30 19:56
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
 * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.

 * Example 1
     * Input: head = [1,0,1]
     * Output: 5
     * Explanation: (101) in base 2 = (5) in base 10
 * Example 2
     * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
     * Output: 18880
 **/

/** 链表节点定义 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    /**
     * 设置下个节点
     * @param nextValue 下个节点的值
     */
    public void setNext(int nextValue) {
        next = new ListNode(nextValue);
    }
}

/**
 * @author Tristan
 */
public class ConvertBinaryNumberInaLinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head!=null) {
            result = result*2 + head.val;
            head = head.next;
        }
        return result;
    }

    /**
     * 辅助方法，用于实现从节点值数组转为链表
     * @param valueArray
     * @return
     */
    public static ListNode ConvertArray2List(int[] valueArray) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for(int value : valueArray) {
            current.setNext(value);
            current = current.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ConvertBinaryNumberInaLinkedListToInteger convertBinaryNumberInaLinkedListToInteger = new ConvertBinaryNumberInaLinkedListToInteger();

        // 测试用例1，期待输出：5
        ListNode list1 = ConvertBinaryNumberInaLinkedListToInteger.ConvertArray2List(new int[]{1,0,1});
        System.out.println(convertBinaryNumberInaLinkedListToInteger.getDecimalValue(list1));

        // 测试用例2，期待输出：18880
        list1 = ConvertBinaryNumberInaLinkedListToInteger.ConvertArray2List(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0});
        System.out.println(convertBinaryNumberInaLinkedListToInteger.getDecimalValue(list1));
    }
}
