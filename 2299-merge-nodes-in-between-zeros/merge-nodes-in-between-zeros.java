/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode temp=head;
        ListNode resultHead=new ListNode(0);
        ListNode resultTail=resultHead;
        int sum=0;
        temp=temp.next;
        while(temp!=null){
            if(temp.val==0){
                resultTail.next=new ListNode(sum);
                resultTail=resultTail.next;
                sum=0;
            }
            else{
                sum+=temp.val;
            }
            temp=temp.next;
        }
        return resultHead.next;
    }
}