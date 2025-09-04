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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null || head.next==null || head.next==null){
            return new int[]{-1,-1};
        }
        ListNode prev=head;
        ListNode cur=head.next; 
        List<Integer>positions=new ArrayList<>();
        int index=1;
        
        while(cur.next!=null){
            if((cur.val>prev.val && cur.val>cur.next.val)||(cur.val<prev.val && cur.val<cur.next.val)){
                positions.add(index);
            }
            prev=cur;
            cur=cur.next;
            index++;
        }
        if(positions.size()<2){
            return new int[]{-1,-1};
        }

        int minDist=Integer.MAX_VALUE;
        for(int i=1;i<positions.size();i++){
            minDist=Math.min(minDist,positions.get(i)-positions.get(i-1));
        }

        int maxDist=positions.get(positions.size()-1)-positions.get(0);
        return new int[]{minDist,maxDist};
    }
}