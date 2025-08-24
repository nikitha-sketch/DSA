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
    public ListNode mergeKLists(ListNode[] lists) {
        /*if(lists==null || lists.length==0)return null;
        ListNode head=lists[0];
        for(int i=1;i<lists.length;i++){
            head=mergeTwoSortedLists(head,lists[i]);
        }
        return head;
    }
    public ListNode mergeTwoSortedLists(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next=list1;
                list1=list1.next;
                temp=temp.next;
            }
            else{
                temp.next=list2;
                list2=list2.next;
                temp=temp.next;
            }
        }
        if(list1!=null){
            temp.next=list1;
        }
        if(list2!=null){
            temp.next=list2;
        }
        return dummy.next;*/

        if(lists==null || lists.length==0)return null;

        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list:lists){
            if(list!=null){
                pq.offer(list);
            }
        }

        ListNode dummy=new ListNode();
        ListNode curr=dummy;

        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            curr.next=node;
            curr=curr.next;
            if(node.next!=null){
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}