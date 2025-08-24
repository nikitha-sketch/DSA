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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
       /* ListNode temp1=list1;
        ListNode temp2=list2;
        int cnt=0;
        while(temp1!=null){
            cnt++;
            if(cnt==a){
                temp1.next=list2;
            }
            if(cnt==b){
                while(temp2!=null && temp2.next!=null){
                    temp2=temp2.next;
                }
                temp2.next=list1;
            }
            temp1=temp1.next;
        }
        return list1;*/

        ListNode temp1=list1;
        while(a!=1){
            temp1=temp1.next;
            a--;
        }
        ListNode temp2=list1;
        while(b!=-1){
            temp2=temp2.next;
            b--;
        }
        temp1.next=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=temp2;
        return list1;
    }
}