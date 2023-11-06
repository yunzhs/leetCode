package mine.leetcode.solution;

import mine.leetcode.common.ListNode;

import java.util.Objects;

/**
 * @program: leetCode
 * @description: 两数相加
 * @author: gyw
 * @create: 2022-06-14 18:20
 **/
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1=new ListNode();
        ListNode l2=new ListNode();
        l1.val=2;
        l2.val=5;
        l1.next=new ListNode();
        l2.next=new ListNode();
        l1.next.val=4;
        l2.next.val=6;
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("完成");
    }

    /**
     * 执行用时：
     * 1 ms,在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.2 MB, 在所有 Java 提交中击败了76.47%的用户
     * 通过测试用例：1568 / 1568
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode pre = result;
        boolean plusFlag=false;
        while (Objects.nonNull(l1)||Objects.nonNull(l2)||plusFlag){
            int i=0;
            int j=0;
            if(Objects.nonNull(l1)){
                i=l1.val;
                l1=l1.next;

            }
            if(Objects.nonNull(l2)){
                j=l2.val;
                l2=l2.next;
            }
            int sum = i + j;
            if(plusFlag){
                sum=sum+1;
                plusFlag=false;
            }
            if(sum>9){
                plusFlag=true;
            }
            pre.next=new ListNode(sum%10);
            pre = pre.next;

        }
        return result.next;
    }

    public ListNode addTwoNumbersAnswer(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;

    }
}
